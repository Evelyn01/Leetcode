package com.leetcode.maxpointsonline;


import java.util.HashMap;

public class Solution {

    public static void main(String[] strings) {
        Point[] points = initTestPoints3();
        Solution solution = new Solution();
        int max = solution.maxPoints(points);
        System.out.println(max);
    }

    private static Point[] initTestPoints3() {
        Point[] points = new Point[3];

        points[0] = new Point(0, 0);
        points[1] = new Point(1, 1);
        points[2] = new Point(1, -1);

        return points;
    }

    private static Point[] initTestPoints2() {
        Point[] points = new Point[4];

        points[0] = new Point(1, 1);
        points[1] = new Point(1, 1);
        points[2] = new Point(2, 2);
        points[3] = new Point(2, 2);

        return points;
    }

    private static Point[] initTestPoints() {
        Point[] points = new Point[9];

        points[0] = new Point(1, 0);
        points[1] = new Point(2, 1);
        points[2] = new Point(0, -1);

        points[3] = new Point(10, 1);
        points[4] = new Point(10, 2);

        points[5] = new Point(5, 5);
        points[6] = new Point(6, 5);

        points[7] = new Point(0, -2);
        points[8] = new Point(2, 2);

        return points;
    }


    public int maxPoints(Point[] points) {
        if (points == null)
            return 0;

        if (points.length == 1)
            return 1;

        if (points.length == 2)
            return 2;

        HashMap<Double, Integer> hashMap = new HashMap<Double, Integer>();
        int max = 0;
        for (int i = 0 ; i < points.length ; i ++) {
            hashMap.clear();
            int localMax = 0;
            int vertical = 1;
            int overlap = 0;
            for (int j = 0 ; j < points.length ; j ++) {
                if (i != j) {
                    if (points[i].x == points[j].x) { //vertical line case
                        vertical ++;
                        if (points[i].y == points[j].y) {
                            overlap ++;
                        }
                    } else {
                        double slope = calcSlope(points[i], points[j]);
                        int count = 1;
                        if (hashMap.containsKey(slope)) {
                            count = hashMap.get(slope);
                        }

                        count ++;
                        if (count > localMax) {
                            localMax = count;
                        }
                        hashMap.put(slope, count);
                    }
                }
            }

            localMax += overlap;

            if (localMax > max) {
                max = localMax;
            }

            if (vertical > max) {
                max = vertical;
            }
        }

        return max;
    }

    double calcSlope(Point a, Point b) {
        return ((double)b.y - (double)a.y) / ((double)b.x - (double)a.x);
    }


    /**
     * Definition for a point.
     */
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

}
