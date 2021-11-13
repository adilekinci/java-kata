package com.training.codewars;

import java.util.Arrays;
import java.util.stream.Stream;

public class Xbonacci {
    public double[] tribonacci(double[] s, int n) {
        if (n == 0) return new double[0];
        double result[] = new double[n];

        int i = 0;
        while (i < n) {
            if (i < 3) {
                result[i] = s[i];

            } else {
                result[i] = result[i - 3] + result[i - 1] + result[i - 2];
            }
            i++;
        }
        return result;
    }
    public double[] tribonacci2(double[] s, int n) {

        double[] tritab=Arrays.copyOf(s, n);
        for(int i=3;i<n;i++){
            tritab[i]=tritab[i-1]+tritab[i-2]+tritab[i-3];
        }
        return tritab;
    }
    public double[] tribonacci3(double[] s, int n) {
        double[] r = new double[n];
        for(int i = 0; i < n; i++){
            r[i] = (i<3)?s[i]:r[i-3]+r[i-2]+r[i-1];
        }
        return r;
    }
    public double[] tribonacci4(double[] start, int n) {
        return Stream.iterate(start, tuple -> applySequenceRule(tuple))
                .mapToDouble(tuple -> tuple[0])
                .limit(n)
                .toArray();
    }

    public double[] tribonacci5(double[] s, int n) {
        double[] result = Arrays.copyOf(s, n);
        for(int counter = 3; counter < n; counter++){
            result[counter] = result[counter-1] + result[counter-2] + result[counter-3];
        }
        return result;
    }

    private double[] applySequenceRule(double[] tuple) {
        return new double[]{tuple[1], tuple[2], tuple[0]+tuple[1]+tuple[2]};
    }

    public static void main(String[] args) {
        Xbonacci test = new Xbonacci();

        System.out.println(test.tribonacci(new double[]{17.0, 19.0, 11.0}, 1));

    }
}
/*
Well met with Fibonacci bigger brother, AKA Tribonacci.

As the name may already reveal, it works basically like a Fibonacci, but summing the last 3 (instead of 2) numbers of the sequence to generate the next. And, worse part of it, regrettably I won't get to hear non-native Italian speakers trying to pronounce it :(

So, if we are to start our Tribonacci sequence with [1, 1, 1] as a starting input (AKA signature), we have this sequence:

[1, 1 ,1, 3, 5, 9, 17, 31, ...]
But what if we started with [0, 0, 1] as a signature? As starting with [0, 1] instead of [1, 1] basically shifts the common Fibonacci sequence by once place, you may be tempted to think that we would get the same sequence shifted by 2 places, but that is not the case and we would get:

[0, 0, 1, 1, 2, 4, 7, 13, 24, ...]
Well, you may have guessed it by now, but to be clear: you need to create a fibonacci function that given a signature array/list, returns the first n elements - signature included of the so seeded sequence.

Signature will always contain 3 numbers; n will always be a non-negative number; if n == 0, then return an empty array (except in C return NULL) and be ready for anything else which is not clearly specified ;)

If you enjoyed this kata more advanced and generalized version of it can be found in the Xbonacci kata

[Personal thanks to Professor Jim Fowler on Coursera for his awesome classes that I really recommend to any math enthusiast and for showing me this mathematical curiosity too with his usual contagious passion :)]
 */