package SearchingAndSorting;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr){
        // base case we have one size arr.
        if(arr.length <=  1)
            return;
        // each arr is divided to two from its mid.
        int n = arr.length;
        int mid = arr.length/2;
        int[] left = new int[mid];      // left sub arr.
        int[] right = new int[n - mid]; // right sub arr.

        // prepare left sub array.
        for(int i = 0;i<mid;i++){
            left[i] = arr[i];
        }

        //prepare right sub array.
        for(int i = mid;i<n;i++){
            right[i-mid]=arr[i];
        }
        // sort the two subArray.
        mergeSort(left);
        mergeSort(right);
        //goes on until we get single size arr like [38], [27] , [43] ...
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int arrArrSize = left.length + right.length;

        int l=0, r =0; // left and right arr index.
        int s=0; // arrult arr index.
        while(l < left.length && r < right.length){
            if(left[l] <= right[r])
                arr[s++] = left[l++];
            else
                arr[s++] = right[r++];
        }
        // assuming all left is done but we still have element to add to right
        while(r < right.length){
            arr[s++] = right[r++];
        }
        // assuming right was longer and we have to take care of left remaining elements.
        while(l < left.length) {
            arr[s++] = left[l++];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Test Case 1 - Random Array");
        System.out.println("Before sorting: " + Arrays.toString(arr1));
        mergeSort(arr1);
        System.out.println("After sorting:  " + Arrays.toString(arr1));
    }
}
