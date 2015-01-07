package com.practise1;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {

        int[][] a = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},

        };

        TestPractise testPractise = new TestPractise();
        //List<Integer> ret = testPractise.spiralOrder(a);
        //outputList(ret);
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new LinkedList<Interval>();
        if (intervals == null || intervals.size() == 0) return ret;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.valueOf(o1.start).compareTo(o2.start);
            }
        });

        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                ret.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        ret.add(new Interval(start, end));

        return ret;
    }

    public static class Interval {
        public int start;
        public int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}


