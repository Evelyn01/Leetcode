package com.leetcode.validnum;

/**
 * Created by titan-developer on 11/5/14.
 */
public class ValidNumber {

    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }

        return s.matches("(\\s*)[+-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))(e[+-]?[0-9]+)?(\\s*)");
    }

    public boolean isNumberNonRegular(String s) {
        try {
            s = s.trim();
            int n = s.length();
            if ( n == 0 || (s.charAt(n-1) != '.' && (s.charAt(n-1) - '0' < 0 || s.charAt(n-1) - '0' > 9 )) ) {
                return false;
            }
            double i = Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
