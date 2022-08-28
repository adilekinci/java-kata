package com.training.leetcode.easy;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        int first=1;
        int second=1;
        int tmp;
        for(int i=0; i<n-1; i++) {
            tmp = first;
            first = first + second;
            second = tmp;
        }

        return first;
    }
    public static void main(String[] args) {
        System.out.println(ClimbingStairs.climbStairs(5));
    }
}


