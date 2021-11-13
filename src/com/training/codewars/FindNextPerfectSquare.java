package com.training.codewars;

public class FindNextPerfectSquare {
    public static long findNextSquare(long sq) {
        long n = (long) Math.sqrt(sq);
        return (sq != Math.pow(n,2)) ? -1 : (long)Math.pow(n+1,2);
    }
    public static long findNextSquare2(long sq) {
        return Math.sqrt(sq) % 1 != 0 ? -1 : (long)Math.pow(Math.sqrt(sq)+1,2);
    }
    public static long findNextSquare3(long sq) {
        long result;
        double d = Math.sqrt(sq);

        //if your number d is a integer result will be true, if not will be -1;
        //good luck)!
        if ( d % 1  == 0) {
            result = (long) Math.pow(++d, 2);
        } else result = -1;

        return result;
    }
    public static long findNextSquare4(long sq) {
        return (long) ((Math.round(Math.sqrt(sq))==Math.sqrt(sq)) ? Math.pow(Math.sqrt(sq) + 1, 2) : - 1);
    }

    public static void main(String[] args) {
        long l = (long)Math.sqrt(11);
        if (Math.pow(l, 2)!=11)
            System.out.println("-1");
        System.out.println(Math.sqrt(11));
        System.out.println(l);
    }
}
/*
You might know some pretty large perfect squares. But what about the NEXT one?

Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter. Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.

If the parameter is itself not a perfect square then -1 should be returned. You may assume the parameter is positive.

Examples:

findNextSquare(121) --> returns 144
findNextSquare(625) --> returns 676
findNextSquare(114) --> returns -1 since 114 is not a perfect
 */