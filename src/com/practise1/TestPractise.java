package com.practise1;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {

        int[][] a = {
                {0, 1},

        };

        char[][] b = {
                {'a'},
        };

        TestPractise testPractise = new TestPractise();
        System.out.println(testPractise.exist(b, "a"));
        System.out.println();
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word.length() == 0) return true;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int i, int j, String target, int index) {
        if(index == target.length()) return true;
        char c = target.charAt(index);
        boolean isSucc = false;
        if (board[i][j] == c) {
            if (index + 1 == target.length()) return true;
            board[i][j] = ' ';
            if (i > 0)
                isSucc = dfs(board, i - 1, j, target, index + 1);
            if (!isSucc && j < board[0].length - 1)
                isSucc = dfs(board, i, j + 1, target, index + 1);
            if (!isSucc && i < board.length - 1)
                isSucc = dfs(board, i + 1, j, target, index + 1);
            if (!isSucc && j > 0)
                isSucc = dfs(board, i, j - 1, target, index + 1);
            board[i][j] = c;
        }

        return isSucc;
    }
}


