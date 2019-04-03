package algorithms.leetcode;

public class NextPermutation {

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

    /* Solution:
Start from its last element, traverse backward to find the first one with index i that satisfy num[i-1] < num[i]. So, elements from num[i] to num[n-1] is reversely sorted.

To find the next permutation, we have to swap some numbers at different positions, to minimize the increased amount, 
we have to make the highest changed position as high as possible. Notice that index larger than or equal to i is not possible as num[i,n-1] is reversely sorted. 
So, we want to increase the number at index i-1, clearly, swap it with the smallest number between num[i,n-1] that is larger than num[i-1]. 
For example, original number is 121543321, we want to swap the '1' at position 2 with '2' at position 7.
The last step is to make the remaining higher position part as small as possible, we just have to reversely sort the num[i,n-1]

https://www.youtube.com/watch?v=quAS1iydq7U
    */
    
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        for(int j = nums.length - 2;j>= 0;j--){             
            if(nums[j] < nums[j+1]){                            //Scan from last to first, to find the break point
                for(int k = nums.length - 1;j<k;k--){
                    if(nums[j] < nums[k]){                      //Scan from last to swap the break point with the least cost
                        int temp = nums[k];
                        nums[k] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                reverseArray(nums,j+1,nums.length - 1);         //swap the descending subarry to ascending order
                return;
            }
        }
        reverseArray(nums,0,nums.length - 1);                   //corner case, {3,2,1} -> {1,2,3}
    }

    private void reverseArray(int[] nums, int begin, int end) {
        for(int i = begin, j = end;i<j;i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}