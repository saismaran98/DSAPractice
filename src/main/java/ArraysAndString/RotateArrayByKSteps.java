package ArraysAndString;

import java.util.Arrays;

public class RotateArrayByKSteps {

    public static void rotate(int[] nums, int k){
        int n = nums.length ;
        k = k % n; // to handle k > n
        reverse(nums, 0, n - 1 );
        reverse(nums, 0, k-1);
        reverse(nums, k, n - 1);
    }
    public static void reverse(int[] nums, int k, int n){

        if(k >= n )
            return; //while ( k<n) condition in recursion

        int temp = nums[k];
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        rotate(nums,2);
    }
}
