package com.training.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public ValidParentheses() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
    public static boolean isValid(String s) {
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('(',')');
        parentheses.put('[',']');
        parentheses.put('{','}');
        parentheses.put(')','x');
        parentheses.put('}','x');
        parentheses.put(']','x');

        if (s.length()<=1 || s.length() % 2 != 0 )
            return false;

        if (s.length()==2)
            return s.charAt(1) == parentheses.get(s.charAt(0));

        return isStraight(s, parentheses) || cascaded(s, parentheses) ? true : false;

    }
    private static boolean isStraight(String s, Map<Character, Character> ph) {
        for (int i =0; i<=s.length()-2; i+=2) { //(){}}{
            if ( !ph.get(s.charAt(i)).equals(s.charAt(i+1)))
                return false;
        }
        return true;
    }
    private static boolean cascaded(String s, Map<Character, Character> ph) {

        int middle = s.length() %2 ==0 ? (s.length()/2)-1 : (s.length()-1) / 2;
        for (int i = 0; i <= middle; i++ ) {
            if ( !(s.charAt(middle+i+1) == ph.get(s.charAt(middle-i))))
                return false;
        }
        return true;
    }

    public boolean isValid2(String s) {
        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String p = "{([)]}";
        ValidParentheses test = new ValidParentheses();

        /*System.out.println(test.isValid("")); //FALSE
        System.out.println(test.isValid("(")); //FALSE
        System.out.println(test.isValid("{}"));//TRUE
        System.out.println(test.isValid("}{"));//FALSE
        System.out.println(test.isValid("{([)]}"));//FALSE
        System.out.println(test.isValid("{[]}"));//TRUE
        System.out.println(test.isValid("(){}}{"));//FALSE
        System.out.println(test.isValid(")(){}"));//FALSE
        System.out.println(test.isValid("([]){"));//FALSE
        System.out.println(test.isValid("]()"));//FALSE*/
        System.out.println(test.isValid("(([]){})"));//FALSE

    }
}
