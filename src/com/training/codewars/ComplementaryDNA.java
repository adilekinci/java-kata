package com.training.codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ComplementaryDNA {
    public static String makeComplement(String dna) {
        Map<Character, Character> dnaAlphabets = new HashMap<>();
        dnaAlphabets.put('A', 'T');
        dnaAlphabets.put('T', 'A');
        dnaAlphabets.put('C', 'G');
        dnaAlphabets.put('G', 'C');
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < dna.length(); i++) {
            buffer.append(dnaAlphabets.get(dna.charAt(i)).toString());
        }

        return buffer.toString();
    }

    public static String makeComplement2(String dna) {
        char[] chars = dna.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            chars[i] = getComplement(chars[i]);
        }

        return new String(chars);
    }
    public static String makeComplement3(String dna) {
        dna = dna.replaceAll("A","Z");
        dna = dna.replaceAll("T","A");
        dna = dna.replaceAll("Z","T");
        dna = dna.replaceAll("C","Z");
        dna = dna.replaceAll("G","C");
        dna = dna.replaceAll("Z","G");
        return dna;
    }
    public static String makeComplement4(String dna) {
        return dna.replace("A","B")
                .replace("C","D")
                .replace("T","A")
                .replace("G","C")
                .replace("B","T")
                .replace("D","G");
    }

    private static HashMap<Character, Character> map = new HashMap<>(4);
    static {map.put('A', 'T'); map.put('T', 'A'); map.put('C', 'G'); map.put('G', 'C');}
    public static String makeComplement5(String dna) {
        return dna.chars().mapToObj(c -> String.valueOf(map.get((char)c))).collect(Collectors.joining());
    }

    private static char getComplement(char c) {
        switch(c) {
            case 'A': return 'T';
            case 'T': return 'A';
            case 'C': return 'G';
            case 'G': return 'C';
        }
        return c;
    }
    public static String makeComplement6(String dna) {
        char[] chars = dna.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (char c : chars){
            switch (c){
                case 'A': {builder.append("T"); break;}
                case 'T': {builder.append("A"); break;}
                case 'C': {builder.append("G"); break;}
                case 'G': {builder.append("C"); break;}
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(ComplementaryDNA.makeComplement("ATTGC"));
        System.out.println(ComplementaryDNA.makeComplement("GTAT"));


    }
}
