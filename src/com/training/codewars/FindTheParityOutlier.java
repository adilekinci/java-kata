package com.training.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheParityOutlier {
    static int find(int[] integers) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i =0; i<integers.length; i++) {
            if (integers[i] % 2 == 0) {
                if (odd.size() > 1) return integers[i];
                even.add(integers[i]);

            }else {
                if (even.size() > 1) return integers[i];
                odd.add(integers[i]);
            }

        }
        return even.size() == 1 ? even.get(0) : odd.get(0);
    }

    public static void main(String[] args) {
        System.out.println(FindTheParityOutlier.find(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}));
        System.out.println(FindTheParityOutlier.find(new int[]{160, 3, 1719, 19, 11, 13, -21}));
    }

    public static int find2(int[] integers) {
        // Since we are warned the array may be very large, we should avoid counting values any more than we need to.

        // We only need the first 3 integers to determine whether we are chasing odds or evens.
        // So, take the first 3 integers and compute the value of Math.abs(i) % 2 on each of them.
        // It will be 0 for even numbers and 1 for odd numbers.
        // Now, add them. If sum is 0 or 1, then we are chasing odds. If sum is 2 or 3, then we are chasing evens.
        int sum = Arrays.stream(integers).limit(3).map(i -> Math.abs(i) % 2).sum();
        int mod = (sum == 0 || sum == 1) ? 1 : 0;

        return Arrays.stream(integers).parallel() // call parallel to get as much bang for the buck on a "large" array
                .filter(n -> Math.abs(n) % 2 == mod).findFirst().getAsInt();
    }

    static int find3(int[] integers) {
        int oddcount = 0, odd = 0, evencount = 0, even = 0;
        for (int i : integers) {
            if (i % 2 == 0) {
                even = i;
                evencount++;
            } else {
                odd = i;
                oddcount++;
            }
            if (evencount > 0 && oddcount > 0) {
                if (evencount > 1) {
                    return odd;
                } else if (oddcount > 1) {
                    return even;
                }
            }
        }
        return evencount > 1 ? odd : even;
    }
    static int find4(int[] integers) {
        int[] array = Arrays.stream(integers).filter(i -> i % 2 == 0).toArray();
        return array.length == 1 ? array[0] : Arrays.stream(integers).filter(i -> i % 2 != 0).findAny().getAsInt();
    }
    static int find5(int[] integers){
        int[] odd = Arrays.stream(integers).filter(n -> n % 2 != 0).toArray();
        int[] even = Arrays.stream(integers).filter(n -> n % 2 == 0).toArray();

        return odd.length == 1 ? odd[0] : even[0];
    }
    static int find6(int[] integers) {
        int even = 0;
        int odd = 0;
        int cycle = 0;

        for(Integer value : integers) {
            if(value % 2 == 0) {
                cycle++;
                even = value;
            }else {
                odd = value;
            }
        }
        return (cycle > 1) ? odd : even;
    }

}
/*
Description:
You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.

Examples
[2, 4, 0, 100, 4, 11, 2602, 36]
Should return: 11 (the only odd number)

[160, 3, 1719, 19, 11, 13, -21]
Should return: 160 (the only even number)
 */