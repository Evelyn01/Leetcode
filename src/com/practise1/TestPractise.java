package com.practise1;

import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodePrinter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {

        char[][] a = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'},

        };


        char[][] b = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
        };

        int ca = 5;

        int[] gas = {1, 2};
        int[] cost = {2, 1};

        Point[] points = new Point[3];
        points[0] = new Point(2, 3);

        points[1] = new Point(3, 3);

        points[2] = new Point(-5, 3);

        char[] buf = new char[100];
        ListNode head = ListNode.createList("2->3->1->6->5->7->4");
        TestPractise testPractise = new TestPractise();
        System.out.println(testPractise.maxPoints(points));
    }

    private static void outputTree(List<TreeNode> treeNodes) {
        for (TreeNode root : treeNodes) {
            TreeNodePrinter.printNode(root);
            System.out.println("------------------");
        }
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
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

    public int maxPoints(Point[] points) {
        //duplicate points, vertical line
        if (points == null || points.length == 0) return 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int ret = 0;
        for (int i = 0; i < points.length; i ++) {
            map.clear();
            int dup = 1;
            for (int j = i + 1; j < points.length; j ++) {
                if (i == j) continue;
                //same points
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup ++;
                } else {
                    double slope = calcSlope(points[i], points[j]);
                    int count = map.containsKey(slope) ? map.get(slope) : 0;
                    count++;
                    map.put(slope, count);
                }
            }
            if (dup > ret) ret = dup;
            Iterator<Integer> iterator = map.values().iterator();
            while(iterator.hasNext()) {
                int count = iterator.next();
                if (count + dup > ret) ret = count + dup;
            }
        }
        return ret;
    }

    double calcSlope(Point a, Point b) {
        if (a.x == b.x) return Double.MAX_VALUE;
        if (a.y == b.y) return 0.0d;
        return (double) (a.y - b.y) / (double) (a.x - b.x);
    }

}


