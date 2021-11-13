package com.training.leetcode.easy;

public class PolindromNumber {
    public boolean isPalindrome(int x) {
        int tmp = x;
        if (x <= 0)
            return false;

        int reversenumber = 0;
        while (x > 0) {
            reversenumber = reversenumber * 10 + x % 10;
            x /=10;
        }
        System.out.println(reversenumber);
        return (tmp == reversenumber) ? true : false;

    }

    public static void main(String[] args) {

        PolindromNumber test = new PolindromNumber();
        System.out.println(test.isPalindrome(121));
        System.out.println(test.isPalindrome(1441));

    }
}
