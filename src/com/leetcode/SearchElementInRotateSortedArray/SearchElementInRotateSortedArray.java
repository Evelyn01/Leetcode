package com.leetcode.SearchElementInRotateSortedArray;

/**
 * Created by titan-developer on 9/15/14.
 * http://leetcode.com/2010/04/searching-element-in-rotated-array.html
 */
public class SearchElementInRotateSortedArray {

    public static void main(String[] strings) {
        int[] array = {6, 7, 0, 1, 2, 4, 5};
        SearchElementInRotateSortedArray searchElementInRotateSortedArray = new SearchElementInRotateSortedArray();
        System.out.println(searchElementInRotateSortedArray.rotated_binary_search(array, 4));
        System.out.println(searchElementInRotateSortedArray.rotated_binary_search(array, 7));
    }

    /**
     * @param array
     * @param key
     * @return index of the key
     */
    int rotated_binary_search(int array[], int key) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int length = array.length;

        int left = 0;
        int right = length - 1;

        while (left < right) {
            int pivot = (right - left) / 2 + left;

            if (array[pivot] == key) {
                return pivot;
            }

            //upper sorted array
            if (array[pivot] < array[right]) {
                if (key == array[right]) {
                    return right;
                }

                if (key > array[pivot] && key < array[right]) {
                    left = pivot;
                } else {
                    right = pivot;
                }

            } else if (array[pivot] > array[left]) {
                if (key == array[left]) {
                    return left;
                }

                if (key < array[pivot] && key > array[left]) {
                    right = pivot;
                } else {
                    left = pivot;
                }
            }

        }

        return -1;
    }
}
