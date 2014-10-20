package com.leetcode.containerwithmostwater;

/**
 * Created by titan-developer on 10/20/14.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int len = height.length, low = 0, high = len -1 ;
        int maxArea = 0;
        while (low < high) {
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
}
