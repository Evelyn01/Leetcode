package com.leetcode.util;

import java.util.List;

/**
 * Created by titan-developer on 12/20/14.
 */
public class ListPrinter <E> {
    public void output(List<List<E>> lists) {
        for (List<E> list : lists) {
            for (E e : list) {
                System.out.print(e + ", ");
            }
            System.out.println();
        }
    }
}
