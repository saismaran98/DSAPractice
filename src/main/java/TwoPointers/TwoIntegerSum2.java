package TwoPointers;

import java.util.Arrays;

public class TwoIntegerSum2 {
    public static int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right = numbers.length-1;

        while(left<right){
            int curSum = numbers[left]+numbers[right];
            if(curSum == target)
                return new int[]{left+1, right+1};
            else if(curSum > target)
                right--;
            else
                left++;
        }


        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,3,4}, 6)));
    }
}
