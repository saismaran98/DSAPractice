package ArraysAndString;


import java.lang.reflect.Array;
import java.util.*;

public class TwoPointerProblems {
    public static int removeDuplicates(int[] arr) {
        int slow = 0;
        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[slow] != arr[fast]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return slow + 1; //no. of duplicates found.
    }

    // Move all zeroes in an array to one side without changing the order of other elements.
    public static void moveZeroesToEnd(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                swapFastAndSlow(nums, fast, slow);
                slow++;
            }
        }
    }
    public static void moveZeroApproach2(int[] nums){
        /*@sidharthPandey solution*/
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0)
                nums[count++]=nums[i];
        }
        while(count<nums.length)
            nums[count++]=0;
        System.out.println(Arrays.toString(nums));
    }
    /**
     * @param arr
     * @param target Given a sorted array of integers and a target value, find all unique pairs of numbers in the array whose sum equals the target value.
     *                  Example:
     *                  <p>
     *                  Input: array = [1, 2, 3, 4, 5, 6], target = 7
     *                  Output: [(1, 6), (2, 5), (3, 4)]
     */
    public static void twoSum(int[] arr, int target) {
        List<int[]> result = new ArrayList<>();
        int left = 0, right = arr.length - 1;

        // Two-pointer technique
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                result.add(new int[]{arr[left], arr[right]});
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        result.stream().map(pair -> "(" + pair[0] + ", " + pair[1] + ")")
                .forEach(System.out::println);
    }

    // Find the maximum sum of a subarray of size k
    public static int maxSum(int[] arr, int subArrySize){
        int windowSum = 0;
        int maxSum = 0;
        // 1st windowSum
        for(int i=0;i<subArrySize;i++)
            windowSum+=arr[i];

       for(int start = subArrySize;start<arr.length;start++){
           windowSum+=arr[start]-arr[start-subArrySize]; //remove the last index of the window to get the other two sum
           maxSum=Math.max(maxSum, windowSum);
       }
       return maxSum;
    }
    public static void mergeSortedArray(int[] nums1, int[] nums2, int m,  int n) {
        // Start from the end
        int p1 = m - 1;    // Last element in nums1
        int p2 = n - 1;    // Last element in nums2
        int p = m + n - 1; // Last position in merged array

        while (p2 >= 0) {  // Continue until all nums2 elements are processed
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        System.out.println(Arrays.toString(nums1));
    }
    // Longest Substring without repeating char.
    public static int longestSubStringWithoutRepeatingChar(String s){
        if(s.length()==0)return 0;
        int slow=0;

        int maxSubStringLen = 0;
        Set<Character> uniqChar=new HashSet<>();
        for(int fast=0;fast<s.length();fast++){
            while(uniqChar.contains(s.charAt(fast))){
                uniqChar.remove(s.charAt(slow++));

            }
            uniqChar.add(s.charAt(fast));
            maxSubStringLen=Math.max(maxSubStringLen, fast - slow +1 );
        }
        return maxSubStringLen;
    }
    public static void removeElement(int[] nums, int val){
        int pointer=0;
        for(int num:nums){
            if(num!=val)
                nums[pointer++]=num;
        }
        System.out.println("removeElement: "+pointer);
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        testRemoveDuplicates();
        testMoveZerrosToEnd();
        testTwoSum();
        testMaxSum();
        testMergedSortedArrays();
        testLongestSubStringWithoutRepeatingChar();
        testRemoveElement();
    }

    private static void testRemoveElement() {
        int[] arr = {3,2,2,3};
        removeElement(arr, 3);
    }

    private static void testLongestSubStringWithoutRepeatingChar() {
        String s = "abcabcbb";
        System.out.println(longestSubStringWithoutRepeatingChar(s));
    }

    private static void testMergedSortedArrays() {
        int[] arr1 = {1, 3, 7, 0, 0, 0};
        int[] arr2 = {2,5,6};
        mergeSortedArray(arr1, arr2, 3,3);
    }

    private static void testMaxSum() {
        int[] arr = {1,5,4,2,9,9,9};
        int maxSum = maxSum(arr, 3);
        System.out.println(maxSum);
    }

    private static void testTwoSum() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        twoSum(arr, 8);
    }

    private static void testMoveZerrosToEnd() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroesToEnd(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void testRemoveDuplicates() {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("no. of unique element in the array is: " +
                removeDuplicates(arr));
    }

    private static void swapFastAndSlow(int[] nums, int fast, int slow) {
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;
    }
}
