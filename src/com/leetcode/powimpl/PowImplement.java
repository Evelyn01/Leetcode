package com.leetcode.powimpl;

/**
 * Created by titan-developer on 11/3/14.
 */
public class PowImplement {

    public static void main(String[] strings) {
        PowImplement pow = new PowImplement();
        System.out.println(pow.pow(2.0d, - 2));
    }

    public double pow(double x, int m) {
        double temp = x;
        if (m == 0)
            return 1;
        temp = pow(x, m / 2);
        if (m % 2 == 0)
            return temp * temp;
        else {
            if (m > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }

}
