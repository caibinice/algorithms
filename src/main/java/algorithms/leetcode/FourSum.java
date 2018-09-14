package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourSum {

    /**
     * Given an array nums of n integers and an integer target,
     * are there elements a, b, c, and d in nums such that a + b + c + d = target?
     * Find all unique quadruplets in the array which gives the sum of target.
     * Note:
     * The solution set must not contain duplicate quadruplets.
     * <p>
     * Example:
     * <p>
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     * <p>
     * A solution set is:
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     */
    //和3Sum类似，记录重复元素的最后位置，直接遍历
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> sl = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            sl.put(nums[i], i);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    int target0 = target - nums[i] - nums[j] - nums[k];
                    if (sl.containsKey(target0) && sl.get(target0) > k) {
                        j = sl.get(nums[j]);
                        k = sl.get(nums[k]);
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], target0));
                    }
                }
            }
            i = sl.get(nums[i]);  // To remove duplicates
        }
        return res;
    }

    //和3Sum类似，使用滑动法双指针
    public List<List<Integer>> fourSumV2(int[] num, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(num.length<4)return ans;
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++){
            if(num[i]+num[i+1]+num[i+2]+num[i+3]>target)break; //first candidate too large, search finished
            if(num[i]+num[num.length-1]+num[num.length-2]+num[num.length-3]<target)continue; //first candidate too small
            if(i>0&&num[i]==num[i-1])continue; //prevents duplicate result in ans list
            for(int j=i+1; j<num.length-2; j++){
                if(num[i]+num[j]+num[j+1]+num[j+2]>target)break; //second candidate too large
                if(num[i]+num[j]+num[num.length-1]+num[num.length-2]<target)continue; //second candidate too small
                if(j>i+1&&num[j]==num[j-1])continue; //prevents duplicate results in ans list
                int low=j+1, high=num.length-1;
                while(low<high){
                    int sum=num[i]+num[j]+num[low]+num[high];
                    if(sum==target){
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while(low<high&&num[low]==num[low+1])low++; //skipping over duplicate on low
                        while(low<high&&num[high]==num[high-1])high--; //skipping over duplicate on high
                        low++;
                        high--;
                    }
                    //move window
                    else if(sum<target)low++;
                    else high--;
                }
            }
        }
        return ans;
    }

}
