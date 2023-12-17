package com.qi.blocking;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue2<E> implements BlockingQueue<E> {
    private E[] array;
    /**
     * 保证线程安全
     */
    private AtomicInteger size = new AtomicInteger();
    private int head;
    private int tail;
    private ReentrantLock headLock = new ReentrantLock();
    private ReentrantLock tailLock = new ReentrantLock();
    private Condition headWaits = headLock.newCondition();
    private Condition tailWaits = tailLock.newCondition();

    @SuppressWarnings("all")
    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public void offer(E e) throws InterruptedException {
        tailLock.lock();
        try {
            // 1.队列满则等待。
            while (isFull()) {
                tailWaits.await();
            }
            // 2.不满则入队
            array[tail] = e;
            if (++tail> array.length) {
                tail = 0;
            }
            // 3.修改size

            /*
            1.读取成员变量size的值
            2.自增
            3.结果写回成员变量size
             */
            size.incrementAndGet();
            // 锁要配对

        } finally {
            tailLock.unlock();
        }
        headLock.lock();
        try {
            headWaits.signal();
        } finally {
            headLock.unlock();
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {

        return false;
    }
    @Override
    public E poll() throws InterruptedException {
        E remove;
        headLock.lock();
        try {
            // 1. 队列空则等待
            while (isEmpty()) {
                headWaits.await();
            }
            // 2. 非空则出队
            remove = array[head];
            array[head] = null;
            if (++head > array.length) {
                head = 0;
            }
            // 3. 修改size
            size.decrementAndGet();
            // 使用和解锁的"锁"要配对

        } finally {
            headLock.unlock();
        }
        tailLock.lock();
        try {
            tailWaits.signal();
        } finally {
            tailLock.unlock();
        }
        return remove;
    }

    private boolean isFull() {
        return size.get() == array.length;
    }

    private boolean isEmpty() {
        return size.get() == 0;
    }
}
