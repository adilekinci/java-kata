package com.training.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n < 10)
            return Integer.toString(n);
        Map<Integer, Integer> numbers = new HashMap<>();
        int tmp;
        while (n > 0) {
            tmp = n % 10;
            n = n / 10;
            if (numbers.containsKey(tmp)) {
                numbers.put(tmp, (numbers.get(tmp) + 1));
            } else {
                numbers.put(tmp, 1);
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            buffer.append(entry.getValue());
            buffer.append(entry.getKey());
        }
        return buffer.toString();
    }

    public String countAndSay2(int n) {
        if (n == 1) return "1";
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            ans = f(ans);
        }
        return ans;
    }

    String f(String s) {
        char ch = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != ch) {
                sb.append(count).append(ch);
                ch = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count).append(ch);
        return sb.toString();
    }

    public String countAndSay3(int n) {
        //First one is set to "1", and we build using this
        String result = "1";
        for (int i = 2; i <= n; i++) {
            //next is used to build the next one.
            StringBuilder next = new StringBuilder();
            //index is the one used to iterate over the characters in result (previous value)
            int index = 0;
            int count = 1;
            while (index < result.length()) {
                //we write to next if it's the last character or the current character is not equal to the next character
                if (index == result.length() - 1 || result.charAt(index) != result.charAt(index + 1)) {
                    next.append(count).append(result.charAt(index));
                    count = 1;
                }
                //if current char is equal to next character just increment the counter
                else {
                    count++;
                }
                index++;
            }
            result = next.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        CountAndSay test = new CountAndSay();
        System.out.println(test.countAndSay(1123453));
    }
}
