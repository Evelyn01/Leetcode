package com.leetcode.largestrectangle;

/**
 * Created by titan-developer on 10/21/14.
 */
public class LargestRectangleArea {

    public static void main(String[] strings) {
        int[] height = {2, 1, 5, 6, 2, 3};
        int[] height1 = {2, 1, 5, 100, 2, 3};
        int[] height2 = {2, 2, 3, 3, 4, 3};
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleAreaON2(height));
        System.out.println(largestRectangleArea.largestRectangleAreaON2(height1));
        System.out.println(largestRectangleArea.largestRectangleAreaON2(height2));
    }

    /**
     * Big O N2
     * @param height
     * @return
     */
    public int largestRectangleAreaON2(int[] height) {
        int max = 0;

        if (height == null || height.length == 0)
            return max;

        if (height.length == 1) {
            return height[0];
        }

        int[][] maxHeight = new int[height.length][height.length];

        maxHeight[0][0] = height[0];
        max = height[0];
        for (int i = 1; i < height.length ; i ++) {
            maxHeight[i][i] = height[i];
            if (height[i] > max) {
                max = height[i];
            }

            for (int j = 0; j < i ; j ++) {
                maxHeight[j][i] = Math.min(maxHeight[j][i-1], height[i]);
                int rectSize = (i - j + 1) * maxHeight[j][i];
                if (rectSize > max) {
                    max = rectSize;
                }
            }
        }

        return max;
    }
}
