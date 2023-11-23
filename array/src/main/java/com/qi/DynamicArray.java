package com.qi;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer>{
    /**
     * 默认数组有效长度
     */
    int size = 0;
    int capacity = 10;
    int[] arr = new int[capacity];

    /**
     * 添加数组
     * @param target 目标值
     */
    public void addLast(int target) {
        checkAndGrow();
        add(size,target);
    }

    private void checkAndGrow() {
        if (capacity == size) {
            capacity += capacity >>> 1;
            int[] newArr = new int[capacity];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
    }


    /**
     * 指定数组下标添加数组
     * @param index 数组的索引值
     * @param target 目标值
     */
    public void add(int index,int target) {
        if (index >= 0 && index < size) {
            System.arraycopy(arr, index, arr, index + 1, size - index);
        }
        arr[index] = target;
        size++;
    }

    public void foreach() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    public int get(int index) {
        return arr[index];
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return size < i ;
            }

            @Override
            public Integer next() {
                return arr[i++];
            }
        };
    }

    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(arr, 0, size));
    }

    public int remove(int index) {
        int removed = arr[index];
        if (index < size - 1) {
            System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        }
        size--;
        return removed;
    }
}
