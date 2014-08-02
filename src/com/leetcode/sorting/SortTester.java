package com.leetcode.sorting;

/**
 * Created by bod on 8/2/14.
 */
public class SortTester {
    Sorter sorter;

    public SortTester(Sorter sorter) {
        this.sorter = sorter;
    }

    public void testSort() {
        int[] testArray = new int[]{3, 5, 1, 9, 8, 7, 4};
        sorter.sort(testArray);

        printArray(testArray);

        testArray = new int[]{};
        sorter.sort(null);
        printArray(testArray);

        testArray = new int[]{};
        sorter.sort(testArray);
        printArray(testArray);

        testArray = new int[]{1};
        sorter.sort(testArray);
        printArray(testArray);

        testArray = new int[]{1, 2};
        sorter.sort(testArray);
        printArray(testArray);
    }

    private void printArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("empty array");
        } else {
            for (int i : array) {
                System.out.println(i);
            }
        }
        System.out.println("-----------");
    }
}
