package com.training.leetcode.easy;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 *
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 104
 *     s consists of only English letters and spaces ' '.
 *     There will be at least one word in s.
 */
public class LengthOfLastWord {
    public static int lengthOfWord(String s) {
        if (s == null || s.trim().length()==0) {
            return 0;
        }
        s = s.trim();
        int pos = s.lastIndexOf(" ");
        String lastWord =s.substring(pos+1);
        return lastWord.length();
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
         * Memory Usage: 42.1 MB, less than 60.77% of Java online submissions for Length of Last Word.
         */
    }

    public int lengthOfLastWord_solution2(String s) {
        s = s.trim();
        String words[] = s.split(" ");
        return words[words.length - 1].length();
    }

    public int lengthOfLastWord_solution3(String s) {
        int sum=0;
        for(int i=s.length()-1;i>0;i--){
            if(s.charAt(i)!=' '){
                sum++;
                if(s.charAt(i-1)==' '){
                    return sum;
                }
            }

        }
        return ++sum;
    }

    public static void main(String[] args) {
        System.out.println(LengthOfLastWord.lengthOfWord("   fly me   to   the moon  "));
    }
}

