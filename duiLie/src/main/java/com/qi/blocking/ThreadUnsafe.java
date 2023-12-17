package com.qi.blocking;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadUnsafe {
    private final String[] array = new String[10];
    private int tail = 0;
    private int size = 0;
    ReentrantLock lock = new ReentrantLock(); // 锁对象
    Condition timeWaits = lock.newCondition(); // 条件变量对象 集合
    public void offer(String value) throws InterruptedException {
        //lock.lock(); // 加锁
        lock.lockInterruptibly(); // 加锁（可以在阻塞状态随时打断）
        try {
            //从tailWaits中唤醒的线程，会与新来的offer的线程争抢锁，谁能抢到是不一定的，
            // 如果后者先抢到，就会导致条件又发生变化这种情况称之为虚假唤醒，
            // 唤醒后应该重新检查条件，看是不是得重新进入等待
            while (isFull()) {
                // 满了该做的事，offer 线程阻塞
                timeWaits.await(); // 当前线程加入tailWaits，并且让此线程阻塞
                // tailWaits.signal() 阻塞的线程唤醒 必须配合锁对象进行使用
            }
            array[tail] = value;
            if (++tail==array.length) {
                tail = 0;
            }
            size++;
        } finally {
            lock.unlock(); // 解锁
        }
    }

    public boolean isFull() {
        return size == array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "ThreadUnsafe{" +
                "array=" + Arrays.toString(array) +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) {
        ThreadUnsafe threadUnsafe = new ThreadUnsafe();
        for (int i = 0; i < 10; i++) {
            try {
                threadUnsafe.offer("e" + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"添加元素之前");
                threadUnsafe.offer("e10");
                System.out.println(Thread.currentThread().getName()+"添加元素成功");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t1").start();
        new Thread(() -> {
            System.out.println("开始唤醒");
            try {
                threadUnsafe.lock.lockInterruptibly();
                threadUnsafe.timeWaits.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                threadUnsafe.lock.unlock();
            }
        },"t2").start();
    }
}
