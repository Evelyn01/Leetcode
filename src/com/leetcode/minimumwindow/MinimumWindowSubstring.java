package com.leetcode.minimumwindow;

/**
 * Created by titan-developer on 10/21/14.
 */
public class MinimumWindowSubstring {

    public static void main(String[] strings) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        String subStr = "";
        if (s == null || t == null)
            return subStr;


        return subStr;
    }
}
