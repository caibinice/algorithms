package algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

/**
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 Output: [[1,5],[6,9]]
 Example 2:

 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 Output: [[1,2],[3,10],[12,16]]
 Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].*/

    /**
     * Definition for an interval.
     */
    public class Interval {
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


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> newIns = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            newIns.add(newInterval);
            return newIns;
        }
        int start = newInterval.start;
        int end = newInterval.end;
        boolean hasNew = false, creatNew = false;
        for (Interval inter : intervals) {
            if (start > inter.end) {
                newIns.add(inter);
            } else if (end < inter.start) {
                if (!hasNew) {
                    newIns.add(newInterval);
                    hasNew = true;
                    creatNew = true;
                } else if (!creatNew) {
                    newInterval.start = start;
                    newInterval.end = end;
                    newIns.add(newInterval);
                    creatNew = true;
                }
                newIns.add(inter);
            } else {
                start = Math.min(start, inter.start);
                end = Math.max(end, inter.end);
                hasNew = true;
            }
        }
        if (!hasNew || !creatNew) {
            newInterval.start = start;
            newInterval.end = end;
            newIns.add(newInterval);
        }
        return newIns;
    }

    //类似的直接插入
    public List<Interval> insertV2(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }

}
