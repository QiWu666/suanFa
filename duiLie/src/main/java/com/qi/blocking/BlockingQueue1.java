package com.qi.blocking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue1<E> implements BlockingQueue<E> {
    private E[] array;
    private int size;
    private int head;
    private int tail;
    private ReentrantLock lock = new ReentrantLock();
    private Condition headWaits = lock.newCondition();
    private Condition tailWaits = lock.newCondition();

    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public void offer(E e) throws InterruptedException { //poll 等待队列非空的线程
        lock.lockInterruptibly();
        try {
            while (isFull()) {
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail > array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
        } finally {
            lock.unlock();
        }

    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        lock.lock();
        try {
            long nanos = TimeUnit.MICROSECONDS.toNanos(timeout);
            while (isFull()) {
                long l = tailWaits.awaitNanos(nanos);// 返回值代表剩余时间
                if (l<0) {
                    return false;
                }
            }
            array[tail] = e;
            if (++tail > array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isFull()) {
                headWaits.await();
            }
            E e = array[head];
            array[head] = null; // help GC
            if (++head > array.length) {
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
