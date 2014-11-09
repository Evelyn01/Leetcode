package com.leetcode.scramblestring;

/**
 * Created by titan-developer on 11/8/14.
 */
public class ScrambleString {

    public static void main(String[] strings) {
        ScrambleString scrambleString = new ScrambleString();
        System.out.println(scrambleString.isScramble("great", "rgeat"));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        return false;
    }
}
