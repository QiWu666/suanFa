package com.qi.hashTable.leet;

import java.util.HashMap;

/**
 * 检查数组中重复元素
 */
public class LeetCode217 {
    public boolean containsDuplicate1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            if (map.containsKey(key)) {
                return true;
            }
            map.put(key, key);
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Object o = new Object();
        HashMap<Integer, Object> map = new HashMap<>();
        for (int key : nums) {
            Object put = map.put(key, o);
            if (put != null) {
                return true;
            }
            map.put(key, key);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode217().containsDuplicate(new int[]{1, 2, 3, 4}));
    }
}
