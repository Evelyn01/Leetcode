package com.practise1;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {

        int[][] a = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},

        };

        TestPractise testPractise = new TestPractise();
        List<Integer> ret = testPractise.spiralOrder(a);
        outputList(ret);
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ret;
        int x = 0, y = 0, direction = 0, left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        ret.add(matrix[y][x]);
        while(ret.size() < matrix.length * matrix[0].length) {
            boolean isMove = false;
            while(!isMove) {
                switch(direction) {
                    case 0: {
                        if (x < right) {
                            isMove = true;
                            x ++;
                        } else {
                            top ++;
                            direction = 1;
                        }
                        break;
                    }
                    case 1: {
                        if (y < bottom) {
                            isMove = true;
                            y ++;
                        } else{
                            right --;
                            direction = 2;
                        }
                        break;
                    }
                    case 2: {
                        if (x > left) {
                            isMove = true;
                            x --;
                        } else {
                            bottom --;
                            direction = 3;
                        }
                        break;
                    }
                    case 3: {
                        if (y > top) {
                            isMove = true;
                            y --;
                        } else {
                            left ++;
                            direction = 0;
                        }
                        break;
                    }
                }
                if (isMove) ret.add(matrix[y][x]);
            }
        }
        return ret;
    }
}
