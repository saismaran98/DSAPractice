package ArraysAndString;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // we use hashmap as we need
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                return new int[] {map.get(comp),i}; //map.get(comp) : return compliment index, else we can use set.
            }
            map.put(nums[i],i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{ 7, 11, 15,2}, 9)));;
    }
}
