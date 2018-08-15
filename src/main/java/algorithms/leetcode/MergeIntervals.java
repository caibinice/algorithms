package algorithms.leetcode;

import java.util.*;

public class MergeIntervals {

/**
 Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */

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

        //自己加的方法，方便排序，如不加则使用new Comparator<>{}来实现
        private int getStart() {
            return start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        intervals.sort(Comparator.comparingInt((Interval inter) -> inter.start));
//        intervals.sort((inter1, inter2) -> {
//            return Integer.compare(inter1.start,inter2.start);
//        });
        Stack<Interval> stack = new Stack<>();
        for (Interval inter : intervals) {
            if (stack.empty()) {
                stack.push(inter);
            } else {
                Interval interval = stack.pop();
                if (inter.start <= interval.end) {
                    interval.start = Math.min(inter.start, interval.start);
                    interval.end = Math.max(inter.end, interval.end);
                    stack.push(interval);
                } else {
                    ans.add(interval);
                    stack.push(inter);
                }
            }
        }
        if (!stack.empty())
            ans.add(stack.pop());
        return ans;
    }

}
