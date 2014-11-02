package com.leetcode.permutationsequence;

/**
 * Created by titan-developer on 11/1/14.
 */
public class PermutationSequence {

    public static void main(String[] strings) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(4, 10));
    }

    public String getPermutation(int n, int k) {

        int size = 1;

        for (int i = n ; i > 1 ; i --) {
            size *= i;
        }

        if (k > size) {
            return "";
        }

        return "";
    }

}
