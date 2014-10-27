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

    protected boolean checkQueens(int[][] pos) {
        int size = pos.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (pos[i][j] <= 0)
                    continue;

                //check row
                for (int m = 0; m != j && m < size; m ++) {
                    if (pos[i][m] > 0)
                        return false;
                }

                //check column
                for (int m = 0; m != i && m < size; m ++) {
                    if (pos[m][j] > 0)
                        return false;
                }

                //check diagonal, left-top
                if (i > 0 && j > 0 && pos[i - 1][j - 1] > 0) {
                    return false;
                }

                //check diagonal, left-bottom
                if (i < size - 1 && j > 1 && pos[i + 1][j - 1] > 0) {
                    return false;
                }

                //check diagonal, right-top
                if (i > 0 && j < size - 1 && pos[i - 1][j + 1] > 0) {
                    return false;
                }

                //check diagonal, right-bottom
                if (i < size - 1 && j < size - 1 && pos[i + 1][j + 1] > 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
