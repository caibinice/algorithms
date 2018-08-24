package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * <p>
     * Example:
     * <p>
     * Input: n = 4, k = 2
     * Output:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */

    //MLE，内存占用过多
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) return result;
        List<List<Integer>> ans = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 1; i <= n; n++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(i);
                result.add(subset);
                if (subset.size() == k) {
                    ans.add(subset);
                } else if (subset.size() > k) {
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * Basically, this solution follows the idea of the mathematical formula C(n,k)=C(n-1,k-1)+C(n-1,k).
     * Here C(n,k) is divided into two situations.
     * Situation one, number n is selected, so we only need to select k-1 from n-1 next.
     * Situation two, number n is not selected, and the rest job is selecting k from n-1.
     */
    public List<List<Integer>> combineV2(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        result = combineV2(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combineV2(n - 1, k));
        return result;
    }

}
