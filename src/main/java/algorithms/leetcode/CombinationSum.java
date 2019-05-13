package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    /**
     * Given a set of candidate numbers (candidates) (without duplicates) and a
     * target number (target), find all unique combinations in candidates where the
     * candidate numbers sums to target. The same repeated number may be chosen from
     * candidates unlimited number of times.
     * 
     * Note: All numbers (including target) will be positive integers. The solution
     * set must not contain duplicate combinations. 
     * Example 1:
     * Input: candidates = [2,3,6,7], target = 7, A solution set is: 
     * [ 
     * [7], 
     * [2,2,3]
     * ]
     * 
     * Example 2: Input: candidates = [2,3,5], target = 8, A solution set is: 
     * [
     * [2,2,2,2], 
     * [2,3,3], 
     * [3,5]
     *  ]
     */

    private int[] candidate;
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        candidate = candidates;
        for (int i = 0; i < candidates.length; i++) {
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
        for (int i = index; i < candidate.length; i++) {
            if (candidate[i] > remainedNum/2 && candidate[i] != remainedNum) continue;
            backTrack(i, remainedNum, new LinkedList<>(usedNum));
        }
    }


    //Version II, DP Solution
    public List<List<Integer>> combinationSumV2(int[] candidates, int target) {
        // sort candidates to try them in asc order
        Arrays.sort(candidates); 
        // dp[t] stores all combinations that add up to t
        List<List<Integer>>[] dp = new ArrayList[target+1];
        // build up dp
        for(int t=0; t<=target; t++) {
            // initialize
            dp[t] = new ArrayList();
            // initialize
            List<List<Integer>> combList = new ArrayList();
            
            // for each t, find possible combinations
            for(int j=0; j<candidates.length && candidates[j] <= t; j++) {
                if(candidates[j] == t) {
                    combList.add(Arrays.asList(candidates[j])); // itself can form a list
                } else {
                    for(List<Integer> prevlist: dp[t-candidates[j]]) { // here use our dp definition
                        // i thought it makes more sense to compare with the last element
                        // only add to list when the candidates[j] >= the last element
                        // so the list remains ascending order, can prevent duplicate (ex. has [2 3 3], no [3 2 3])
                        // equal is needed since we can choose the same element many times   
                        if(candidates[j] >= prevlist.get(prevlist.size()-1)){
                            List temp = new ArrayList(prevlist); // temp is needed since 
                            temp.add(candidates[j]); // cannot edit prevlist inside 4eeach looop
                            combList.add(temp);
                        }
                    }
                }
            }
            dp[t] = combList;
        }
        return dp[target];
    } 

    public static void main(String[] args) {
        int[] candidates = {8, 7, 4, 3};
        int target = 11;
        CombinationSum.testAnswer(candidates, target);

    }

    public static void testAnswer(int[] candidates, int target) {
        List<List<Integer>> result = new CombinationSum().combinationSum(candidates, target);
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