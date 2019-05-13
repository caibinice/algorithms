package algorithms.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {

    /** 
    Given a collection of candidate numbers (candidates) and a target number (target), 
    find all unique combinations in candidates where the candidate numbers sums to target.
    Each number in candidates may only be used once in the combination.
    Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

    Example 1:
    Input: candidates = [10,1,2,7,6,1,5], target = 8,
    A solution set is:
    [
      [1, 7],
      [1, 2, 5],
      [2, 6],
      [1, 1, 6]
    ]

    Example 2:
    Input: candidates = [2,5,2,1,2], target = 5,
    A solution set is:
    [
      [1,2,2],
      [5]
    ]
    */

    private int[] candidate;
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        candidate = candidates;
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > target/2 && candidates[i] != target) continue;
            backTrack(i, target, new LinkedList<>());
        }
        return result;
    }

    private void backTrack(int index, int remain, List<Integer> usedNum) {
        if (candidate[index] == remain) {
            List<Integer> list = new LinkedList<>(usedNum);
            list.add(candidate[index]);
            result.add(list);
            return;
        }
        int remainedNum = remain - candidate[index];
        usedNum.add(candidate[index]);
        for (int i = index + 1; i < candidate.length; i++) {
            if (i > index + 1 && candidate[i] == candidate[i-1]) continue;
            if (candidate[i] > remainedNum/2 && candidate[i] != remainedNum) continue;
            backTrack(i, remainedNum, new LinkedList<>(usedNum));
        }
    }
    
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        CombinationSumII.testAnswer(candidates, target);
    }

    public static void testAnswer(int[] candidates, int target) {
        List<List<Integer>> result = new CombinationSumII().combinationSum2(candidates, target);
        StringBuilder sb = new StringBuilder();
        sb.append("[ \n");
        for (List<Integer> var : result) {
            sb.append("[");
            for (Integer num : var) {
                sb.append(num.toString() + ",");
            }
            sb.append("] \n");
        }
        sb.append("]");
        System.out.print(sb.toString());
    }
}