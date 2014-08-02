package com.leetcode.sorting;

/**
 * Created by bod on 8/2/14.
 */
public class SelectionSort {

    public static void main(String[] strings) {
        SelectionSort selectionSort = new SelectionSort();
        int[] testArray = new int[]{3,5,1,9,8,7,4};
        selectionSort.sort(testArray);

        printArray(testArray);

        testArray = new int[]{};
        selectionSort.sort(null);
        printArray(testArray);

        testArray = new int[]{};
        selectionSort.sort(testArray);
        printArray(testArray);

        testArray = new int[]{1};
        selectionSort.sort(testArray);
        printArray(testArray);

        testArray = new int[]{1, 2};
        selectionSort.sort(testArray);
        printArray(testArray);
    }

    private static void printArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("empty array");
        } else {
            for (int i : array) {
                System.out.println(i);
            }
        }
        System.out.println("-----------");
    }

    public void sort(int[] input) {
        if (input == null || input.length == 0 || input.length == 1) {
            return;
        }

        int minIndex;
        for (int i = 0 ; i < input.length ; i ++) {
            minIndex = i;
            for (int m = i ; m < input.length ; m ++) {
                if (input[m] < input[minIndex]) {
                    minIndex = m;
                }
            }

            if (minIndex != i) {
                int temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
            }
        }
    }
}
