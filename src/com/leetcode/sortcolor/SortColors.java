package com.leetcode.sortcolor;

/**
 * Created by titan-developer on 11/7/14.
 */
public class SortColors {

    public static void main(String[] strings) {
        //int[] a = {1, 1, 0, 2, 0, 1, 1, 0};
        int[] a = {0,2,1,2,0,0,1,2,1,1,1,0,2,1,2,1,1,1,1,2,1,0,0,0,1,2,2,0,2,1,0,0,1,2,2,1,2,1,0,0,0,0,2,0,2,1,2,1,1,1,1,0,1,2,0,0,0,0,0,0,2,1,1,0,0,1,1,0,0,0,0,1,1,2,2,0,2,1,1,1,2,0,1,1,1,0,2,1,1,2,2,0,1,0,0,1,0,2,2,1,2,1,2,0,0};
        //int[] a = {1, 0};

        SortColors sorter = new SortColors();
        sorter.sortColors(a);

        for (int i : a) {
            System.out.print(i + ", ");
        }
    }

    public void sortColors(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int left = 0; int right = a.length - 1;
        while (left < a.length && a[left] == 0) {
            left ++;
        }

        while (right >= 0 && a[right] == 2) {
            right --;
        }

        int current = left;
        while (current <= right) {
            if (a[current] == 0) {
                if (current == left) {
                    current ++;
                    left ++;
                } else {
                    a[current] = a[left];
                    a[left] = 0;
                    left++;
                }
            } else if (a[current] == 2){
                a[current] = a[right];
                a[right] = 2;
                right --;
            } else {
                current ++;
            }
        }
    }
}
