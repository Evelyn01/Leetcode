package com.leetcode.dividetwointegers;

/**
 * Created by titan-developer on 10/24/14.
 * https://oj.leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {

    public static void main(String[] strings) {

        DivideTwoIntegers divider = new DivideTwoIntegers();
        System.out.println(divider.divide(50, 16));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new RuntimeException("divide 0");
        }

        if (dividend < divisor) {
            return 0;
        }

        int ori = dividend;
        int bit = 0;
        while (dividend > divisor) {
            dividend = dividend >> 1;
            bit ++;
        }
        bit --;

        return 1 << bit + divide(ori - dividend << 1, divisor);
    }
}
