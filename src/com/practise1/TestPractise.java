package com.practise1;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {
        TestPractise testPractise = new TestPractise();
//        int[] a = {1, 2, 3, 5, 6, 7, 8};
//        int[] a = {1, 2, 3};
//        int[] a = {3, 2, 1};
        int[] a = {-2, -3, -4, 0, -1};

        //System.out.println(testPractise.multiply("-12345", "-6789"));
        System.out.println(testPractise.countAndSay(2));
        System.out.println(Arrays.toString(a));
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public String countAndSay(int n) {
        StringBuffer ret = new StringBuffer();
        ret.append('1');
        int i = 2;
        while (i <= n) {
            int len = ret.length();
            int index = len - 1;
            int count = 0;
            char last_c = '0';
            while(index >= 0) {
                char c = ret.charAt(index);
                if (c == last_c || last_c == '0') {
                    last_c = c;
                    count ++;
                } else {
                    ret.delete(index + 1, index + count + 1);
                    ret.insert(index + 1, last_c);
                    ret.insert(index + 1, (char)(count + '0'));
                    last_c = c;
                    count = 1;
                }
                index --;
            }
            ret.delete(index + 1, index + count + 1);
            ret.insert(0, last_c);
            ret.insert(0, (char)(count + '0'));
            i ++;
        }
        return ret.toString();
    }
}
