package com.leetcode.SearchElementInRotateSortedArray;

/**
 * Created by titan-developer on 10/20/14.
 * <p/>
 * Below solution works both for :
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinInRotateSortedArray {

    public static void main(String[] strings) {
        int array[] = {4, 5, 6, 7, 0, 0, 1, 2, 2, 3};

        FindMinInRotateSortedArray findMin = new FindMinInRotateSortedArray();

        System.out.println(findMin.findMin(array));
    }

    public int findMin(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        } else if (array.length == 1) {
            return array[0];
        }

        int length = array.length;

        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int pivot = (right - left) / 2 + left;

            if (pivot > 0 && array[pivot - 1] > array[pivot]) {
                return array[pivot];
            }

            if (array[pivot] > array[pivot + 1]) {
                return array[pivot + 1];
            }

            //upper sorted array
            if (array[pivot] <= array[right]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return array[0];
    }
}
