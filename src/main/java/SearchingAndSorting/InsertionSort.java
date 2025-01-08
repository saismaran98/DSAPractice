package SearchingAndSorting;

import java.util.Arrays;

public class InsertionSort {
    //basic approach.
    public static int[] sort(int[] arr){

    // assume your first element is sorted, this you your sorted array now you insert all element and sort you array while you insert, hence insertion sort.
       //assumtion: array or elemnts before sortedIndex is sorted.
        //for sortedIndex = 0, since we have one element it sorted!. starting from 1.
        for(int i = 1; i < arr.length ;i++){
            if(arr[i] < arr[i-1]){
                //elemnt is out of place.
                for(int j = i;j>0;j--)
                {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;

                }
                //arr[i] is now inserted to sorted array and result array is sorted.
            }

        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{2,3,4,1,6})));;
    }
}
