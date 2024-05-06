package com.qi.hashTable.leet;

import java.util.HashMap;

public class LeetCode01 {
    public static void main(String[] args) {

    }

    /**
     * 思路：
     * 1.循环遍历数组，到每个数字x
     * 2.以target-x作为key到hash表查找
     *  1）若没找到，将x 作为key，它的索引作为value放入hash表
     *  2）若找到了，返回 × 和它配对数的索引即可
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = target - x;
            if (map.containsKey(y)) {
                return new int[]{i, map.get(y)};
            } else {
                map.put(x, i);
            }
        }
        return nums;
    }
}
