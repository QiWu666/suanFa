package com.qi.heap.leet.a295;

import com.qi.heap.Heap;

import java.util.Arrays;

public class Demo1 {

    Heap left = new Heap(10, true);
    Heap right = new Heap(10, false);

    /*
        为了保证两边数据量的平衡
         - 两边个数一样时，左边个数加一
         - 两边个数不一样时，右边个数加一
        但是，随便一个数能直接加入吗？
         - 左边个数加一时，把新元素加在右边，弹出右边最小的加入左边
         - 右边个数加一时，把新元素加在左边，弹出左边最小的加入右边
     */
    public void addNum(int num) {
        if (left.getSize() == right.getSize()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    /**
     * 查找中位数
     * 两边数据一致，左右各取堆顶元素求平均
     * 左边多一个，取左边堆顶元素
     */
    public double findMedian() {
        if (left.getSize() == right.getSize()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return left.peek();
    }

    @Override
    public String toString() {
        return "Demo1{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

    /*    public static void main(String[] args) {
            Demo1 a295 = new Demo1();
            a295.addNum(1);
            a295.addNum(2);
            a295.addNum(3);
            a295.addNum(4);
            a295.addNum(6);
            a295.addNum(7);
            a295.addNum(8);
            a295.addNum(9);
            System.out.println(a295);
            System.out.println(a295.findMedian());
        }*/
    public static void main(String[] args) {
        Heap left = new Heap(5, true);
        for (int i = 0; i <= 10; i++) {
            left.offer(i);
            System.out.println(Arrays.toString(left.array));
        }
    }
}
