package com.training.codewars;

import java.util.stream.Collectors;

public class SquareEveryDigit {
    public int squareDigits(int n) {
        String number = Integer.toString(n);
        StringBuffer buffer = new StringBuffer();
        int tmp;
        for (int i =0 ; i<number.length(); i++) {
            tmp = Integer.parseInt(Character.toString(number.charAt(i)));
            buffer.append(Integer.toString(tmp*tmp));
        }
        return Integer.parseInt(buffer.toString());
    }

    public int squareDigits2(int n) {
        String result = "";

        while (n != 0) {
            int digit = n % 10 ;
            result = digit*digit + result ;
            n /= 10 ;
        }

        return Integer.parseInt(result) ;
    }
    public int squareDigits3(int n) {
        return Integer.parseInt(String.valueOf(n)
                .chars()
                .map(i -> Integer.parseInt(String.valueOf((char) i)))
                .map(i -> i * i)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")));
    }
    public int squareDigits4(int n) {
        int BASE = 10;

        if (n < BASE) {
            return n * n;
        }
        int digit = n % BASE;
        int squaredDigit = digit * digit;
        return squaredDigit + (squaredDigit < BASE ? BASE : BASE * BASE) * squareDigits(n / BASE);
    }
    public int squareDigits5(int n) {

        String strDigits = String.valueOf(n);
        String result = "";

        for (char c : strDigits.toCharArray()) {
            int digit = Character.digit(c, 10);
            result += digit * digit;
        }

        return Integer.parseInt(result);
    }
    public int squareDigits6(int n) {

        //Use StringBuffer due to performance
        final StringBuffer result = new StringBuffer();
        int x = 0;

        //As long as we have digits left.
        while (n > 0) {

            //Take the next digit (we are in the decimal system).
            x = n % 10;

            //Delete this digit.
            n = n / 10;

            //Insert at the first position is necessary otherwise we would get a wrong order.
            result.insert(0, x * x);
        }

        return Integer.parseInt(result.toString());
    }
    public int squareDigits7(int n) {
        if (n < 10) return n * n;
        else {
            int h = squareDigits(n / 10);
            int l = n % 10;
            return Integer.parseInt(h + "" + l * l);
        }
    }

}

/*
For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1.

Note: The function accepts an integer and returns an integer
 */
