package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RetrieveAllSubsets {

    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     * <p>
     * Note: The solution set must not contain duplicate subsets.
     * <p>
     * Example:
     * <p>
     * Input: nums = [1,2,3]
     * Output:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     */

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new CopyOnWriteArrayList<>();
        res.add(new ArrayList<Integer>());

        for (int i : nums) {
            for (List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                res.add(a);
            }
        }
        return res;
    }

    public List<List<Integer>> subsetsV2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}
