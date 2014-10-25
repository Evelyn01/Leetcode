package com.leetcode.strstr;

/**
 * Created by titan-developer on 10/24/14.
 */
public class StrStr {

    public static void main(String[] strings) {
        StrStr strStr = new StrStr();

        String a = "this simp a ssimple game";
        System.out.println(strStr.strStr(a, "this"));
    }

    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null
                || needle.length() > haystack.length()) {
            return null;
        }

        if (haystack.length() == 0 && needle.length() == 0) {
            return "";
        }

        if (needle.length() == 0) {
            return haystack;
        }

        int currentMatch = 0;
        for (int i = 0 ; i < haystack.length() ; i ++) {
            char a = haystack.charAt(i);
            char b = needle.charAt(currentMatch);

            if (a == b) {
                currentMatch ++;
                if (currentMatch == needle.length()) {
                    return haystack.substring(i - currentMatch + 1);
                }
            } else if (currentMatch > 0) {
                i = i - currentMatch;
                currentMatch = 0;
            }
        }

        return null;
    }
}
