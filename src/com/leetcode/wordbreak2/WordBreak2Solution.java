package com.leetcode.wordbreak2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by titan-developer on 9/3/14.
 */
public class WordBreak2Solution {


    static String s = "leeter";
    static String[] dict = {"le", "ete", "leet", "er"};

//    static String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//    static String[] dict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};

//    static String s = "a";
//    static String[] dict = {"a"};

    public static void main(String[] strings) {
        WordBreak2Solution wordBreakSolution = new WordBreak2Solution();

        Set<String> set = new HashSet<String>();
        for (String str : dict) {
            set.add(str);
        }

        long time = System.currentTimeMillis();

        boolean canBreak = wordBreakSolution.wordBreak(s, set);

        System.out.println(canBreak + " , " + (System.currentTimeMillis() - time));
    }

    //DP
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() <= 0 || dict == null) {
            return false;
        }

        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        for (int i = 0 ; i < dp.length ; i ++) {
            dp[i] = false;
        }

        dp[length] = true;

        for (int i = length - 1; i >= 0 ; i --) {
            for (int j = i ; j < length ; j ++) {
                String current = s.substring(i, j + 1);
                if (dict.contains(current) && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    public boolean wordBreakSlow(String s, Set<String> dict) {
        if (s == null || s.length() <= 1 || dict == null) {
            return false;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int i = 0;
        int cursor = 0;
        while (i < s.length() || (cursor < i && stack.size() > 0)) {
            if (i > s.length()) {
                i = stack.pop() + 1;
                if (stack.size() > 0) {
                    cursor = stack.peek();
                } else {
                    cursor = 0;
                }
            }

            String sub = s.subSequence(cursor, i).toString();
            if (dict.contains(sub)) {
                stack.push(i);
                cursor = i;
                if (cursor == s.length()) {
                    return true;
                }
                i ++;
            } else {
                i ++;
            }
        }

        return false;
    }
}
