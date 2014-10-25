package com.leetcode.palindromepartitioning1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by titan-developer on 10/25/14.
 */
public class PalindromePartitioning1 {

    public static void main(String[] strings) {

        String s = "xcabccbaa";

        PalindromePartitioning1 partitioning1 = new PalindromePartitioning1();

        List<List<String>> result = partitioning1.partition(s);

        for (List<String> list : result) {
            System.out.println(list);
        }
    }

    public List<List<String>> partition(String s) {

        List<List<String>> result = new LinkedList<List<String>>();

        return result;
    }
}
