package com.victor.algorithmpractice.chapter1;

import java.util.HashMap;

/**
 * @author victor
 * @Description Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @since 2020-03-10
 */
public class LongestSubString {

    public static int getLongestLengthOfSubString(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String s1 = "abcabcabcabc";
        String s2 = "bbbbbbb";
        String s3 = "pwwkew";

        System.out.println(s1 + ", longest length of sub string -> " + getLongestLengthOfSubString(s1));
        System.out.println(s2 + ", longest length of sub string -> " + getLongestLengthOfSubString(s2));
        System.out.println(s3 + ", longest length of sub string -> " + getLongestLengthOfSubString(s3));
    }
}
