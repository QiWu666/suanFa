package com.qi.hashTable.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <h3 color= 'red'>字母异位词分组</h3>
 */
public class LeetCode49 {
    public static void main(String[] args) {
        System.out.println(new LeetCode49().groupAnagrams(new String[]{"abc", "bac", "cba", "dba"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String ch = new String(chars);
            List<String> list = map.get(ch);
            if (list == null) {
                list = new ArrayList<>();
                map.put(str, list);
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
