package com.leetcode.nqueen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 10/27/14.
 */
public class NQueensMy {

    public static void main(String[] strings) {

        NQueensMy nQueensMy = new NQueensMy();
        List<String[]> list = nQueensMy.solveNQueens(4);

        for (String[] queens : list) {
            for (String b : queens) {
                System.out.print(b + ", ");
            }
            System.out.println("");
        }
    }

    public List<String[]> solveNQueens(int n) {
        List<String[]> list = new ArrayList<String[]>();

        if (n < 4) {
            return list;
        }

        int[][] pos = new int[n][n];



        return list;
    }
}
