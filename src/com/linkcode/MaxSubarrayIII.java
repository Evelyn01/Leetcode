package com.linkcode;

import java.util.*;

/**
 * Created by titan-developer on 12/11/14.
 */
public class MaxSubarrayIII {

    public static void main(String[] strings) {
        //int[] a = {-5, -4, -3, -2, -1, 0, 3, 4, 5, 8, 9, 10, 13, 15, 20};
        //int[] a = {-5, -4, -3, -2, -1, 0, 3, 4, 5, 8, 20};
        int[] a = {-1, 4, -2, 3, -2, 3};
        MaxSubarrayIII maxSubarrayIII = new MaxSubarrayIII();

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        System.out.println(maxSubarrayIII.maxSubArray(list, 2));
    }

    public int maxSubArray(ArrayList<Integer> nums, int k) {
        int size = nums.size();
        if (k > size) {
            return 0;
        }

        Collections.sort(nums);

        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        int current = 0;
        int last = current;
        int i = size - 1;
        int positiveCount = 0;
        boolean isFirst = true;

        //int[] a = {-5, -4, -3, -2, -1, 0, 3, 4, 5, 8, 9, 10, 13, 15, 20};
        while (i >= 0) {
            int v = nums.get(i);
            if (v <= 0) {
                break;
            }

            positiveCount++;

            if (isFirst) {
                isFirst = false;
                current = v;
            } else {
                if (last - v == 0) {
                    i--;
                    positiveCount --;
                    continue;
                } else if (last - v == 1) {
                    current += v;
                } else {
                    treeSet.add(current);
                    current = v;
                    if (treeSet.size() > k) {
                        treeSet.pollFirst();
                    }
                }
            }
            last = v;
            i--;
        }

        if (current > 0) {
            treeSet.add(current);
            if (treeSet.size() > k) {
                treeSet.pollFirst();
            }
        }

        int sum = 0;
        last = Integer.MAX_VALUE;
        if (treeSet.size() < k && positiveCount < k) {
            while (positiveCount < k) {
                int v = nums.get(i);
                if (v != last) {
                    treeSet.add(v);
                    positiveCount++;
                    last = v;
                }
                i--;
            }
        }

        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        return sum;
    }
}
