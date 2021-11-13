package com.training.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DecodeTheMorseCode {
    public static String decode(String morseCode) {
        String charSplitter=" ";
        String wordSplitter="   ";
        String[] words = morseCode.split(wordSplitter);
        StringBuffer buffer = new StringBuffer();
        for (String word: words) {
            String [] chars = word.split(charSplitter);
            for (String s: chars) {
                String c = MorseCode.get(s);
                if (c !=null && c.length()!=0)
                    buffer.append(c);
            }
            buffer.append(" ");
        }
        return buffer.toString().trim();
    }
    public static String decode2(String morseCode) {
        String result = "";
        for(String word : morseCode.trim().split("   ")) {
            for(String letter : word.split("\\s+")) {
                result += MorseCode.get(letter);
            }
            result += ' ';
        }
        return result.trim();
    }
    public static String decode4(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(MorseCodeDecoder::decodeWord)
                .collect(Collectors.joining(" "));
    }
    public static String decode5(String morseCode) {
        return Arrays.stream(morseCode.split("   "))
                .map(i -> Arrays.stream(i.split(" "))
                        .map(l -> MorseCode.get(l))
                        .filter(l -> l != null)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "))
                .trim();
    }

    private static String decodeWord(String word) {
        return Arrays.stream(word.split(" ")).map(MorseCode::get).collect(Collectors.joining());
    }
}
