package com.leetcode.wordbreak;

import java.util.Set;

/**
 * Created by bod on 8/19/14.
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreakSolution {


    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() <= 1) {
            return false;
        }


        return false;
    }
}
