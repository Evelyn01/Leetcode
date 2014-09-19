package com.leetcode.regularexpression;

/**
 * Created by titan-developer on 9/17/14.
 * https://oj.leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpression {


    /*
    Some examples:
    isMatch("aa","a") → false
    isMatch("aa","aa") → true
    isMatch("aaa","aa") → false
    isMatch("aa", "a*") → true
    isMatch("aa", ".*") → true
    isMatch("ab", ".*") → true
    isMatch("aab", "c*a*b") → true
    */

    public static void main(String[] strings) {
        RegularExpression regularExpression = new RegularExpression();
        System.out.println(regularExpression.isMatch("bbbba", ".*a*a"));
        System.out.println(regularExpression.isMatch("ab", ".*c"));
        System.out.println(regularExpression.isMatch("aaa", "ab*a*c*a"));
        System.out.println(regularExpression.isMatch("aaa", "a*a"));
        System.out.println(regularExpression.isMatch("aa", "a"));
        System.out.println(regularExpression.isMatch("aa", "aa"));
        System.out.println(regularExpression.isMatch("aaa", "aa"));
        System.out.println(regularExpression.isMatch("aa", "a*"));
        System.out.println(regularExpression.isMatch("aa", ".*"));
        System.out.println(regularExpression.isMatch("ab", ".*"));
        System.out.println(regularExpression.isMatch("aab", "c*a*b"));

    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null || s.trim().length() == 0 || p.trim().length() == 0) {
            return false;
        }

        int index_p = 0;
        int index_s = 0;

        int spareCount = 0;
        String spareStr = "";

        while (index_p < p.length()) {
            String p_str = p.substring(index_p, index_p + 1);
            index_p++;
            boolean isWild = false;

            if (index_p < p.length()) {
                String wild = p.substring(index_p, index_p + 1);
                if (wild.equals("*")) {
                    isWild = true;
                    index_p++;

//                    while (index_p < p.length()) {
//                        String temp = p.substring(index_p, index_p + 1);
//                        if (temp.equals(p_str) || temp.equals("*")) {
//                            index_p ++;
//                        } else {
//                            break;
//                        }
//                    }
                }
            }

            if (index_s == s.length()) {
                if (isWild) {
                    continue;
                } else {
                    if (spareStr.equals(p_str) && spareCount > 0)  {
                        spareCount --;
                    } else {
                        return false;
                    }
                }
            } else {
                String ss = s.substring(index_s, index_s + 1);
                if (p_str.equals(".") || p_str.equals(ss)) {
                    if (isWild) {
                        spareStr = ss;
                        spareCount++;
                        index_s++;
                        if (index_s >= s.length())
                            break;

                        ss = s.substring(index_s, index_s + 1);
                        while (p_str.equals(".") || p_str.equals(ss)) {
                            index_s++;

                            if (ss.equals(spareStr)) {
                                spareCount ++;
                            } else {
                                spareStr = ss;
                                spareCount = 1;
                            }

                            if (index_s >= s.length()) {
                                break;
                            }
                            ss = s.substring(index_s, index_s + 1);
                        }
                    } else {
                        spareCount = 0;
                        spareStr = "";
                        index_s++;
                    }
                } else if (isWild) {
                    //index_p ++;
                } else {
                    return false;
                }
            }
        }

        if (index_p == p.length() && index_s == s.length()) {
            return true;
        }

        return false;
    }
}
