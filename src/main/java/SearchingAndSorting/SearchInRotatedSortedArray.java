package SearchingAndSorting;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        // since O(log n) : we use binary search to do the searching.
        int left = 0, right = nums.length - 1;

        while(left <= right ){
            int mid = (left + right ) /2;
            //[ 4,5,6,7,0,1,2 ] = left sorted = [ 4,5,6,7 ] right sorted = [ 0,1,2 ]
            if(target == nums[mid])
                return mid;
            //left sorted portion
            if(nums[left] <= nums[mid]){ // 4 < = 7
                if(target > nums[mid] || target < nums[left]){ // look right sorted
                    left = mid + 1;
                }
                else {
                    // look left
                    right = mid - 1;
                }

            }else{ // right sorted portion
                // sorted left portion.
                if(target < nums[mid] || target > nums[right]){
                    right = mid -1;
                }

                else
                    left = mid + 1;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));;
    }
}
