package com.leetcode.mergeintervals;

import sun.jvm.hotspot.utilities.Interval;

import java.util.*;

/**
 * Created by titan-developer on 10/31/14.
 */
public class MergeIntervals {

    public static void main(String[] strings) {
        int[][] pairs = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};

        List<Interval> list = new ArrayList<Interval>();

        for (int[] pair : pairs) {
            list.add(new Interval(pair[0], pair[1]));
        }

        MergeIntervals merger = new MergeIntervals();
        merger.merge(list);

        for (Interval interval : list) {
            System.out.println(interval.start + " , " + interval.end);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }

        Interval[] intervalsArray = new Interval[intervals.size()];
        for (int x = 0 ; x < intervals.size() ; x ++) {
            intervalsArray[x] = intervals.get(x);
        }

        Arrays.sort(intervalsArray, new IntervalComparator());
        intervals.clear();

        int min = -1, max = -1;
        for (int i = 0 ; i < intervalsArray.length ; i ++) {
            Interval interval = intervalsArray[i];

            if (min < 0 && max < 0) {
                min = interval.start;
                max = interval.end;
            } else {
                if (interval.start <= max) {
                    if (interval.end > max) {
                        max = interval.end;
                    }
                } else {
                    intervals.add(new Interval(min, max));

                    min = interval.start;
                    max = interval.end;
                }
            }
        }
        intervals.add(new Interval(min, max));

        return intervals;
    }

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    static class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start == o2.start) {
                return 0;
            } else if (o1.start < o2.start) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
