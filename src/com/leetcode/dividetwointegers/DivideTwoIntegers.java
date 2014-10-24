package com.leetcode.dividetwointegers;

/**
 * Created by titan-developer on 10/24/14.
 * https://oj.leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {

    public static void main(String[] strings) {

        DivideTwoIntegers divider = new DivideTwoIntegers();
//        System.out.println(divider.divide(33, -3));
//        System.out.println(divider.divide(30, 16));
//        System.out.println(divider.divide(100, 2));
//        System.out.println(divider.divide(1, -1));
        System.out.println(divider.divide(-1010369383, -2147483648));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new RuntimeException("divide 0");
        }

        boolean isPositive = true;

        if (dividend < 0 && divisor < 0) {
            dividend = - dividend;
            divisor = - divisor;
        } else if (dividend < 0 && divisor > 0) {
            dividend = - dividend;
            isPositive = false;
        } else if (dividend > 0 && divisor < 0) {
            divisor = - divisor;
            isPositive = false;
        }

        if (dividend == 0 || dividend < divisor) {
            return 0;
        }

        if (dividend == divisor) {
            return isPositive ? 1 : -1;
        }

        if (divisor == 1) {
            return isPositive ? dividend : - dividend;
        }

        if (divisor == 2) {
            return isPositive? ( dividend >> 1 ) : - ( dividend >> 1 );
        }

        int ori = dividend;
        int bit = 0;
        while (dividend > divisor) {
            dividend = dividend >> 1;
            bit ++;
            if (dividend == divisor) {
                return isPositive ? ( 1 << bit ) : - ( 1 << bit );
            }
        }
        bit --;

        int a = ( 1 << bit ) ;
        int b = divide(ori - ( divisor << bit ), divisor);
        return isPositive ? a + b : - (a + b);
    }
}
