package com.leetcode.validnum;

/**
 * Created by titan-developer on 11/5/14.
 * https://oj.leetcode.com/problems/valid-number/
 */
public class ValidNumber {

    public static void main(String[] strings) {
        ValidNumber validNumber = new ValidNumber();
        System.out.println(validNumber.isNumber("3."));
        System.out.println(validNumber.isNumber("01"));
        System.out.println(validNumber.isNumber(".1"));
        System.out.println(validNumber.isNumber("e"));
        System.out.println(validNumber.isNumber("005047e+6"));
        System.out.println(validNumber.isNumber("-."));
        System.out.println(validNumber.isNumber("6+1"));
        System.out.println(validNumber.isNumber("0e"));
    }

    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }

        return s.matches("(\\s*)[+-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))(e[+-]?[0-9]+)?(\\s*)");
    }
}
