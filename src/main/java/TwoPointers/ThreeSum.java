package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*  Given an integer array nums, return all the triplets [nums[i], nums[j],
 nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and
 k are all distinct. The output should not contain any duplicate triplets.
 You may return the output and the triplets in any order.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // solution cannot contain duplicate. sol'n: sort the array (all duplicate will be adjacent
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length;i++){
        // find the first index for each uniq value. ignoring duplicates.
        if(i > 0 && nums[i] == nums[i-1])
            continue;
        // [-1,0,1,2,-1,-4] -> sorted : [-4, -1, -1, 0, 1, 2]
        int left = i+1, right = nums.length -1;
        while(left < right){
            int sum = nums[i] + nums[left] + nums[ right ];
            if(sum > 0)
                right --;
            else if( sum < 0)
                left ++;
            else{
                // sum == 0,
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;
            while(nums[left]==nums[left - 1])
                left++;
            }
        }
        }
            // time: O(n.logn) + O(n^2) = O(n^2)
            return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{}));
    }


}
