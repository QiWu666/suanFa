package com.qi.likou.a23;

import com.qi.ListNode;

/**
 * 小顶堆
 */
public class MinHeap {
    ListNode[] array;
    int size;

    public MinHeap(int capacity) {
        array = new ListNode[capacity];
    }


    public boolean offer(ListNode offered) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && offered.val < array[parent].val) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = offered;
        return true;
    }

    public ListNode poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0,size-1);
        size--;
        ListNode e = array[size];
        array[size] = null;
        down(0);
        return e;
    }
    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent; // 假设父节点值最小
        if (left < size && array[left].val < array[parent].val) {
            min = left;
        }
        if (right < size && array[right].val < array[parent].val) {
            min = right;
        }
        // 假设的不成立，一定有孩子节点比父节点大
        if (min!=parent) {
            swap(min, parent);
            down(min);
        }
    }

    private void swap(int i, int j) {
        ListNode t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull(){
        return size == array.length;
    }
}
