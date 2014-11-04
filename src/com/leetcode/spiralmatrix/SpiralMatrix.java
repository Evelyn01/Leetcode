package com.leetcode.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/3/14.
 */
public class SpiralMatrix {

    public static void main(String[] strings) {
        int[][] a = {
                {1, 2, 3, 11},
                {4, 5, 6, 12},
                {7, 8, 9, 10}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> list = spiralMatrix.spiralOrder(a);

        for (int v : list) {
            System.out.print(v + ", ");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();

        if (matrix == null || matrix.length == 0) {
            return list;
        }

        int l = matrix.length;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = l - 1;
        int orientation = 0; //0 -> right, 1 -> bottom, 2 -> left, 3 -> up.

        int i = 0, j = 0;

        while (true) {
            list.add(matrix[i][j]);

            int tryTimes = 0;
            while (tryTimes < 2) {
                if (orientation == 0) {
                    if (j + 1 <= right) {
                        j++;
                        break;
                    } else {
                        top ++;
                        orientation ++;
                        tryTimes ++;
                    }
                } else if (orientation == 1) {
                    if (i + 1 <= bottom) {
                        i ++;
                        break;
                    } else {
                        right --;
                        orientation ++;
                        tryTimes ++;
                    }
                } else if (orientation == 2) {
                    if (j - 1 >= left) {
                        j --;
                        break;
                    } else {
                        bottom --;
                        orientation ++;
                        tryTimes ++;
                    }
                } else {
                    if (i - 1 >= top) {
                        i --;
                        break;
                    } else {
                        left ++;
                        orientation = 0;
                        tryTimes ++;
                    }
                }
            }

            if (tryTimes >= 2) {
                break;
            }
        }

        return list;
    }
}
