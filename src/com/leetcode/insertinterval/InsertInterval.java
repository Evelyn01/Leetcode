package com.leetcode.insertinterval;

import com.leetcode.mergeintervals.MergeIntervals;
import com.leetcode.mergeintervals.MergeIntervals.Interval;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/4/14.
 * https://oj.leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    //Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

    //This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

    public static void main(String[] strings) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));

        InsertInterval insert = new InsertInterval();
        intervals = insert.insert(intervals, new Interval(4, 9));

        for (Interval interval : intervals) {
            System.out.print("[" + interval.start + ", " + interval.end + "], ");
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            results.add(newInterval);
            return results;
        }

        int start = 0, end = 0;

        for (Interval i : intervals) {
            if (newInterval.start > i.end) start++;
            if (newInterval.end >= i.start) end++;
            else break;
        }

        if (start == end) {
            results.addAll(intervals);
            results.add(start, newInterval);
            return results;
        }

        for (int i = 0; i < start; i++)
            results.add(intervals.get(i));
        Interval interval = new Interval(Math.min(newInterval.start, intervals.get(start).start), Math.max(newInterval.end, intervals.get(end - 1).end));
        results.add(interval);
        for (int i = end; i < intervals.size(); i++)
            results.add(intervals.get(i));

        return results;
    }

    private int findIndex(List<Interval> intervalList, Interval newInterval, boolean isStart) {
        return 0;
    }
}
