package com.leetcode.wildcardmatching;

/**
 * Created by titan-developer on 10/30/14.
 * https://oj.leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {

    public static void main(String[] strings) {

        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("aa","a"));
        System.out.println(wildcardMatching.isMatch("aa","aa"));
        System.out.println(wildcardMatching.isMatch("aaa","aa"));
        System.out.println(wildcardMatching.isMatch("aa", "*"));
        System.out.println(wildcardMatching.isMatch("aa", "a*"));
        System.out.println(wildcardMatching.isMatch("ab", "?*"));
        System.out.println(wildcardMatching.isMatch("aab", "c*a*b"));
    }

    public boolean isMatch(String s, String p) {
        return false;
    }
}
