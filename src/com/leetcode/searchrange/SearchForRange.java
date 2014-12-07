package com.leetcode.searchrange;

/**
 * Created by titan-developer on 10/29/14.
 * https://oj.leetcode.com/problems/search-for-a-range/
 */
public class SearchForRange {

    public static void main(String[] strings) {
        int a[] = {5, 7, 7, 8, 8, 10};

        SearchForRange searcher = new SearchForRange();
        int[] range = searcher.searchRange(a, 8);
        for (int i : range) {
            System.out.print(i + ", ");
        }
    }

    public int[] searchRange2(int[] A, int target) {
        int[] arr = new int[2];
        arr[0] = searchLeft(A, target);
        arr[1] = searchRight(A, target);
        return arr;
    }

    private int searchLeft(int[] A, int target) {
        int s = 0, e = A.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (A[mid] == target) {
                if (mid == 0) {
                    return mid;
                }
                if (A[mid - 1] == target) {
                    e = mid - 1;
                } else {
                    return mid;
                }
            } else if (target > A[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
    private int searchRight(int[] A, int target) {
        int s = 0, e = A.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (A[mid] == target) {
                if (mid == A.length - 1) {
                    return mid;
                }
                if (A[mid + 1] == target) {
                    s = mid + 1;
                } else {
                    return mid;
                }
            } else if (target > A[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    //----------------------------------------------------------------

    public int[] searchRange(int[] a, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;

        if (a == null || a.length == 0) {
            return range;
        }

        int index = binarySearch(a, target);

        int start = index;
        int end = index;
        while (start > 0 && a[start - 1] == target) {
            start--;
        }

        while (end < a.length - 1 && a[end + 1] == target) {
            end++;
        }

        range[0] = start;
        range[1] = end;

        return range;
    }

    private int binarySearch(int[] a, int target) {
        int index = -1;

        int start = 0, end = a.length - 1;

        while (start <= end) {
            int middle = (end + start) / 2;

            if (a[middle] == target) {
                return middle;
            } else if (a[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return index;
    }
}
