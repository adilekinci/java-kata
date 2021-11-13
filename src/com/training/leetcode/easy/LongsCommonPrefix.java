package com.training.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class LongsCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int len = strs.length;
        int shortest=0;
        String prefix ="";
       /* for (int i=0; i<len ; i++) {
            shortest = strs[i].length() < shortest ? strs[i].length() : shortest;
        }*/
        shortest = Arrays.stream(strs).max(Comparator.comparingInt(String::length)).get().length();


        return prefix;

    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

}
