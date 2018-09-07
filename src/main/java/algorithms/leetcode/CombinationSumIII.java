package algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {

    /**
     * Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     * Note:
     * All numbers will be positive integers.
     * The solution set must not contain duplicate combinations.
     * <p>
     * Example 1:
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * <p>
     * Example 2:
     * Input: k = 3, n = 9
     * Output: [[1,2,6], [1,3,5], [2,3,4]]
     */
    private List<List<Integer>> ans1 = new LinkedList<>();
    private int kk, nn;

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        if (n < (k * (k + 1)) / 2) return ans;
        kk = k;
        nn = n;
        backtrack(new ArrayList<>(), 0);
        ans = ans1;
        return ans;
    }

    private void backtrack(List<Integer> item, int sum) {
        if (sum>nn) return;
        int size = item.size();
        if (size > kk) return;
        if (size == kk) {
            if (sum == nn) {
                List<Integer> item1 = new ArrayList<>(item);
                ans1.add(item1);
            }
            return;
        }
        if (sum==nn) return;
        for (int i = 1; i <= Math.min(nn, 9); i++) {//只能使用数字1-9组成
            if (size > 0 && item.get(size - 1) >= i) continue;
            item.add(i);
            backtrack(item, sum + i);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new CombinationSumIII().combinationSum3(2,18);
        System.out.println();
    }

}
