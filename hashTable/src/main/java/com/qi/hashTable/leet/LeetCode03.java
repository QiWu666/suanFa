package com.qi.hashTable.leet;

import java.util.HashMap;

public class LeetCode03 {
    public static void main(String[] args) {
        System.out.println(new LeetCode03().lengthOfLongestSubString("abba"));
    }

    public int lengthOfLongestSubString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end); // 当前字符
            if (map.containsKey(ch)) {
                Integer i = map.get(ch); // 重复字符串的索引位置
                begin = i + 1;
                // begin = Math.max(begin, i + 1);
                map.put(ch, end);
            } else {
                map.put(ch, end);
            }
            maxLength = Math.max(maxLength, end - begin + 1);
        }
        return maxLength;
    }
}
