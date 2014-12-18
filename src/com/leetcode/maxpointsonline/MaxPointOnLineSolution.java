package com.leetcode.maxpointsonline;


import java.util.HashMap;
import java.util.Iterator;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointOnLineSolution {

    public static void main(String[] strings) {
        Point[] points = initTestPoints3();
        MaxPointOnLineSolution maxPointOnLineSolution = new MaxPointOnLineSolution();
        int max = maxPointOnLineSolution.maxPoints2(points);
        System.out.println(max);
    }

    private static Point[] initTestPoints3() {
        Point[] points = new Point[3];

        points[0] = new Point(2, 3);
        points[1] = new Point(3, 3);
        points[2] = new Point(-5, 3);

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

    public int maxPoints2(Point[] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int dup = 1;
            HashMap<Double, Integer> mp = new HashMap<Double, Integer>();
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y)
                    dup++;
                else if (points[i].x == points[j].x) {
                    int v = mp.containsKey((double)Integer.MAX_VALUE) ? mp.get((double) Integer.MAX_VALUE) : 0;
                    mp.put((double) Integer.MAX_VALUE, v + 1);
                }
                else {
                    double key = points[i].y == points[j].y ? 0.0d : (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
                    int v = mp.containsKey(key) ? mp.get(key) : 0;
                    mp.put(key, v + 1);
                }
            }
            Iterator<Integer> iter = mp.values().iterator();
            int max = 0;
            while (iter.hasNext())
                max = Math.max(max, iter.next());
            max += dup;
            res = res < max ? max : res;
        }
        return res;
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
        for (int i = 0; i < points.length; i++) {
            hashMap.clear();
            int localMax = 0;
            int vertical = 1;
            int overlap = 0;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[i].x == points[j].x) { //vertical line case
                        vertical++;
                        if (points[i].y == points[j].y) {
                            overlap++;
                        }
                    } else {
                        double slope = calcSlope(points[i], points[j]);
                        int count = 1;
                        if (hashMap.containsKey(slope)) {
                            count = hashMap.get(slope);
                        }

                        count++;
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
        return ((double) b.y - (double) a.y) / ((double) b.x - (double) a.x);
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
