package com.qi.hashTable.leet;

import java.util.HashSet;

/**
 * 找出出现一次的数字
 * <P>除了某个元素只出现一次以外，其余每个元素均出现两次。</p>
 */
public class LeetCode136 {
    // TODO P44-48 没听
    /*
    1．准备一个Set集合，逐一放入数组元素
    2．遇到重复的，则删除
    3．最后留下来的，就是那个没有重复的数字
     */
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.toArray(new Integer[0])[0];
    }
    /*
    思路2
        1．任何相同的数字异或，结果都是0
        2.任何数字与 0 异或，结果是数字本身
     */

    public static void main(String[] args) {
        LeetCode136 leetCode136 = new LeetCode136();
        int[] arr1 = new int[]{1, 2, 3, 2, 1};
        int[] arr2 = new int[]{4, 5, 1, 41};
        System.out.println(leetCode136.singleNumber(arr1));
        System.out.println(leetCode136.singleNumber(arr2));
    }
}
