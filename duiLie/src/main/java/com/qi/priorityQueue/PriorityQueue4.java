package com.qi.priorityQueue;

import com.qi.quene.Queue;
// TODO P122
public class PriorityQueue4<E extends Priority> implements Queue<E> {
    private final Priority[] array;
    private int size;

    public PriorityQueue4(int capacity) {
        array = new Priority[capacity];
    }

    /*
    1.入队新元素，加入到数组末尾（索引位置child）
    2.不断比较新加元素与它父节点（parent） 优先级
        -如果父节点优先级低，则向下移动，并找到下一个parent
        直至父节点优先级更高或child==θ为止
     */
    @Override
    public boolean offer(E offered) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && offered.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = offered;
        return true;
    }

    /*
        1.交换堆顶和尾部元素,让尾部元素出队
        2.（下潜）
            从堆顶开始，将父元素与两个孩子较大者交换
            直到父元素大于两个孩子，或没有孩子为止
     */
    @Override
    public E poll() {
        if (empty()) {
            return null;
        }
        swap(0,size-1);
        size--;
        Priority e = array[size];
        array[size] = null;
        down(0);
        return (E) e;
    }

    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent; // 假设父节点值最大
        if (left < size && array[left].priority() > array[parent].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[parent].priority()) {
            max = right;
        }
        // 假设的不成立，一定有孩子节点比父节点大
        if (max!=parent) {
            swap(max, parent);
            down(max);
        }
    }

    private void swap(int i, int j) {
        Priority t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    @Override
    public E peek() {
        return (E) array[0];
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
