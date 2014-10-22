package com.leetcode.reverseinteger;

/**
 * Created by titan-developer on 9/13/14.
 * https://oj.leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public static void main(String[] strings) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverseInteger(123));
        System.out.println(reverseInteger.reverseInteger(-123));
        System.out.println(reverseInteger.reverseInteger(101));
        System.out.println(reverseInteger.reverseInteger(100));
        System.out.println(reverseInteger.reverseInteger(-1010));
    }

    public int reverseInteger(int x) {
        boolean isNegative = false;
        if (x == 0) {
            return 0;
        } else if (x < 0) {
            isNegative = true;
            x = -x;
        }

        int bit = (int) Math.log10(x) + 1;

        int dest = 0;

        for (int i = 0; i < bit; i++) {
            int temp = x % 10;
            dest += temp * Math.pow(10, (bit - i - 1));
            x = x / 10;
        }

        return isNegative ? -dest : dest;
    }
}
