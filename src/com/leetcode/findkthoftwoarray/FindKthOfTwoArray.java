package com.leetcode.findkthoftwoarray;

/**
 * Created by titan-developer on 11/16/14.
 * http://leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html
 */
public class FindKthOfTwoArray {

    public static void main(String[] strings) {

        int[] A = {1, 4, 5, 7, 11, 13};
        int[] B = {6, 8, 9, 10, 14};

        FindKthOfTwoArray finder = new FindKthOfTwoArray();
        System.out.println(finder.findKthSmallest(A, B, 5));
    }

    public int findKthSmallest(int[] A, int[] B, int target) {
        return findKthSmallest(A, 0, A.length, B, 0, B.length, target);
    }

    int findKthSmallest(int A[], int a_s, int m, int B[], int b_s, int n, int k) {
        assert(m >= 0); assert(n >= 0); assert(k > 0); assert(k <= m+n);

        int i = a_s + (int)((double)m / (m+n) * (k-1));
        int j = b_s + (k-1) - (i - a_s);

        assert(i >= 0); assert(j >= 0); assert(i <= m); assert(j <= n);
        // invariant: i + j = k-1
        // Note: A[-1] = -INF and A[m] = +INF to maintain invariant
        int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[i-1]);
        int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[j-1]);
        int Ai   = ((i == m) ? Integer.MAX_VALUE : A[i]);
        int Bj   = ((j == n) ? Integer.MAX_VALUE : B[j]);

        if (Bj_1 < Ai && Ai < Bj)
            return Ai;
        else if (Ai_1 < Bj && Bj < Ai)
            return Bj;

        assert((Ai > Bj && Ai_1 > Bj) ||
                (Ai < Bj && Ai < Bj_1));

        // if none of the cases above, then it is either:
        if (Ai < Bj)
            // exclude Ai and below portion
            // exclude Bj and above portion
            return findKthSmallest(A, i+1, m-i-1, B, b_s, j, k-i-1);
        else /* Bj < Ai */
            // exclude Ai and above portion
            // exclude Bj and below portion
            return findKthSmallest(A, a_s, i, B, j+1, n-j-1, k-j-1);
    }
}
