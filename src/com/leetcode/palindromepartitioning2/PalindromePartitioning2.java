package com.leetcode.palindromepartitioning2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 10/25/14.
 */
public class PalindromePartitioning2 {

    public static void main(String[] strings) {

        String s = "ababababababababababababcbabababababababababababa";
        //String s = "x";

        PalindromePartitioning2 partitioning2 = new PalindromePartitioning2();

        System.out.println(partitioning2.minCut(s));
    }

    public int minCut(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());
        int minForResultN = Integer.MAX_VALUE;

        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            char c = s.charAt(i);
            for (int j = 0; j <= i; j++) {
                if (j == i)
                    pair[j][i] = true;
                else {
                    if (s.charAt(j) != c)
                        continue;
                    if (j == i - 1)
                        pair[j][i] = true;
                    else
                        pair[j][i] = pair[j + 1][i - 1];
                }
                if (pair[j][i]) {
                    String str = s.substring(j, i + 1);
                    for (List<String> r : result[j]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i + 1].add(ri);

                        if (i + 1 == len) {
                            if (ri.size() < minForResultN) {
                                minForResultN = ri.size();
                            }
                        }
                    }
                }
            }
        }

        return minForResultN;
    }
}
