package com.leetcode.trappingrainwater;

import java.util.List;

/**
 * Created by titan-developer on 10/26/14.
 */
public class TrappingRainWater {

    public static void main(String[] strings) {
        //int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] a = {2, 0, 2};

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(a));
    }

    public int trap(int[] a) {
        int size = 0;

        if (a == null || a.length < 2) {
            return 0;
        }

        int maxIndex = -1;
        int lastFrame = -1;
        int base = 0;
        int span = 0;

        for (int i = 0 ; i < a.length ; i ++) {
            if (lastFrame < 0) {
                if (a[i] > 0) {
                    lastFrame = a[i];
                    maxIndex = i;
                }
            } else {
                if (a[i] >= lastFrame) {
                    size += (lastFrame * span) - base;
                    lastFrame = a[i];
                    base = 0;
                    span = 0;
                    maxIndex = i;
                } else {
                    base += a[i];
                    span ++;
                }

            }
        }

        base = 0;
        span = 0;
        lastFrame = -1;

        for (int i = a.length - 1; i >= maxIndex ; i --) {
            if (lastFrame < 0) {
                if (a[i] > 0) {
                    lastFrame = a[i];
                }
            } else {
                if (a[i] >= lastFrame) {
                    size += (lastFrame * span) - base;
                    lastFrame = a[i];
                    base = 0;
                    span = 0;
                } else {
                    base += a[i];
                    span ++;
                }

            }
        }

        return size;
    }
}
