package com.training.leetcode.easy;

public class ReverseInteger {
    public int reverse(int x) {

        double sum=0;
        boolean minus=false;
        if (x < 0) {
            x = x*(-1);
            minus = true;
        }
        while (x>0) {
            int a = x % 10;
            x = x/10;
            sum = (sum *10) + a;
        }
        if (sum ==0 || sum >= Integer.MAX_VALUE || sum <= Integer.MIN_VALUE)
            return 0;
        return minus ? (int)sum*-1: (int)sum;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(-321));
        System.out.println(Integer.MAX_VALUE);
    }
}
