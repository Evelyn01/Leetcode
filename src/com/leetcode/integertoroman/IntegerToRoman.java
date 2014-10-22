package com.leetcode.integertoroman;

/**
 * Created by titan-developer on 10/20/14.
 */
public class IntegerToRoman {

    public static void main(String[] strings) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(10));
        System.out.println(integerToRoman.intToRoman(2014));
        System.out.println(integerToRoman.intToRoman(1954));
        System.out.println(integerToRoman.intToRoman(1990));
        System.out.println(integerToRoman.intToRoman(1066));
        System.out.println(integerToRoman.intToRoman(908));
        System.out.println(integerToRoman.intToRoman(1910));
    }

    //num is a number from 1 to 3999
    public String intToRoman(int num) {
        String romanStr = "";
        if (num < 1 || num > 3999)
            return romanStr;


        int bit0 = num % 10;
        if (bit0 != 0) {
            romanStr = createbitStr(bit0, "I", "V", "X") + romanStr;
        }

        if (num >= 10) {
            int bit1 = num % 100 - bit0;

            if (bit1 != 0) {
                romanStr = createbitStr(bit1 / 10, "X", "L", "C") + romanStr;
            }

            if (num >= 100) {
                int bit2 = num % 1000 - bit1 - bit0;

                if (bit2 != 0) {
                    romanStr = createbitStr(bit2 / 100, "C", "D", "M") + romanStr;
                }

                if (num >= 1000) {
                    int bit3 = num - bit0 - bit1 - bit2;

                    if (bit3 != 0) {
                        romanStr = createbitStr(bit3 / 1000, "M", "-", "-") + romanStr;
                    }
                }
            }
        }

        return romanStr;
    }

    private String createbitStr(int bit, String one, String five, String ten) {
        String bitStr = "";
        switch (bit) {
            case 1:
                bitStr = one;
                break;
            case 2:
                bitStr = one + one;
                break;
            case 3:
                bitStr = one + one + one;
                break;
            case 4:
                bitStr = one + five;
                break;
            case 5:
                bitStr = five;
                break;
            case 6:
                bitStr = five + one;
                break;
            case 7:
                bitStr = five + one + one;
                break;
            case 8:
                bitStr = five + one + one + one;
                break;
            case 9:
                bitStr = one + ten;
                break;
        }

        return bitStr;
    }
}
