package SearchingAndSorting;

public class KClosestElement {
    public static int closestKElementBruitForce(int[] arr, int k){
        int closest = arr[0];
        for(int num : arr){
            if(Math.abs(num - k) < Math.abs(closest - k))
                closest = num;
        }
        return closest;
    }
    public static int closestKElementOptimized(int[] arr, int k){
        // we can implement binary search which will go to the nearest of the k element
        int left = 0;
        int right = arr.length - 1;
        while(left < right ){
            int mid = (left + right) / 2;
            if (arr[mid] == k)
                return arr[mid];
            if(k > arr[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return arr[right];
    }
    public static void main(String[] args) {

        System.out.println("optimized approach: O(log n): "+closestKElementOptimized(new int[]{1,2,5,10,15,20}, 18));
    }
}
