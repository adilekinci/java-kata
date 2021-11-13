package com.training.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class JustSo {

    public static void main(String[] args) {
        /*int i = Integer.MAX_VALUE + 1;

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);
        int a= Integer.MAX_VALUE + 2147483647;
        System.out.println(a);
        System.out.println(i);*/
        String[] strs = {"ab", "abc", "defg"};
        int size = Arrays.stream(strs).max(Comparator.comparingInt(String::length)).get().length();
        System.out.println(size);

    }
}
