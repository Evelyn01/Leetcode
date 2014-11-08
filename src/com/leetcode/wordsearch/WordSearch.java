package com.leetcode.wordsearch;

/**
 * Created by titan-developer on 11/7/14.
 */
public class WordSearch {

    public static void main(String[] strings) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'},
//        };

        char[][] board = {
                {'A'},
        };

        WordSearch wordSearch = new WordSearch();
        //System.out.println(wordSearch.exist(board, "ABCCED"));
        System.out.println(wordSearch.exist(board, "A"));
        //System.out.println(wordSearch.exist(board, "ADEE"));
    }

    public boolean exist(char[][] board, String word) {
        boolean isExist = false;
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;

        int m = board.length, n = board[0].length;

        char[] chars = word.toCharArray();

        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                if (board[i][j] == chars[0]) {
                    isExist = dfs(board, i, j, chars, 0);
                    if (isExist) {
                        return isExist;
                    }
                }
            }
        }

        return isExist;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chars, int start) {
        boolean isExist = false;

        if (start == chars.length) {
            return true;
        }

        if (board[i][j] == chars[start]) {
            board[i][j] = '.';

            if (start + 1 == chars.length) {
                return true;
            }

            if (i > 0) {
                isExist = dfs(board, i - 1, j, chars, start + 1);
            }

            if (!isExist && i < board.length - 1) {
                isExist = dfs(board, i + 1, j, chars, start + 1);
            }

            if (!isExist && j > 0) {
                isExist = dfs(board, i, j - 1, chars, start + 1);
            }

            if (!isExist && j < board[0].length - 1) {
                isExist = dfs(board, i, j + 1, chars, start + 1);
            }

            if (!isExist) {
                board[i][j] = chars[start];
            }
        }

        return isExist;
    }
}
