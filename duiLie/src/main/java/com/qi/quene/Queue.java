package com.qi.quene;

/**
 * 队列类
 * @param <E>
 */
public interface Queue<E> {
    /**
     * 在队尾插入元素
     * @param value 待插入值
     * @return 插入是否成功
     */
    boolean offer(E value);

    /**
     * 从队列中获取值，并移除
     * @return 被移除的元素
     */
    E poll();

    /**
     * 从对列头获取值，不移除
     * @return 如果队列非空返回队头值，否则返回null
     */
    E peek();

    /**检查队列是否为空
     * @return 空返回true，否则返回false
     */
    boolean empty();

    /**
     * 检查队列是否满
     * @return 满返回真
     */
    boolean isFull();
}
