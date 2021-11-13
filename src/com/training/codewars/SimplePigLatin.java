/*
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.

Examples
pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !

 */

package com.training.codewars;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SimplePigLatin {
    public static String pigIt(String str) {
        StringBuffer buffer = new StringBuffer();
        String[] words = str.split(" ");
        String ay = "ay";
        for(int i=0; i< words.length; i++) {
            char first = words[i].charAt(0);
            if (Character.isAlphabetic(first)) {
                String rest = words[i].substring(1);
                buffer.append(rest).append(first).append(ay).append(" ");
            }else {
                buffer.append(words[i]).append(" ");
            }
        }
        return buffer.toString().trim();
    }
    public static String pigIt2(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }
    public static String pigIt3(String str) {
        return Arrays.stream(str.trim().split(" "))
                .map(v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
                .collect(Collectors.joining(" "));
    }
    private static final Pattern regex = Pattern.compile("(\\w)(\\w*)");

    public static String pigIt4(String str) {
        return regex.matcher(str).replaceAll("$2$1ay");
    }
    public static String pigIt5(String str) {
        String[] inputArray = str.split(" ");
        StringBuilder result = new StringBuilder();

        for(String element : inputArray) {
            if( element.length() >= 1 && ( element.toLowerCase().charAt(0) > 96 && element.toLowerCase().charAt(0) < 123) )
                result.append(element.substring(1) + element.substring(0,1)+ "ay" + " ");
            else
                result.append(element+ " ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(SimplePigLatin.pigIt("Pig latin is cool ![]"));
        System.out.println(SimplePigLatin.pigIt("Hello world !"));
    }
}
