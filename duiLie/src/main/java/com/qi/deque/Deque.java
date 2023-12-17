package com.qi.deque;

/**
 * 双端队列接口
 */
public interface Deque<E> {
    boolean offerFirst(E value);

    boolean offerLast(E value);

    E pollFirst();

    E pollLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();

    boolean isFull();
}
