package SearchingAndSorting;

import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] arr, int start, int end) {
        if( (end - start +1)<= 1) // start >=end
            return arr; // only single element present in arr. base case

        int piviot = arr[end];
        int left = start;
        for(int i = start; i < end; i++){
            if(arr[i] < piviot )
            {
                int tmp = arr[left];
                arr[left] = arr[i];
                arr[i] = tmp;
                left++;
            }
        }
        // move piviot between left and right sides.
        arr[end] = arr[left];
        arr[left] = piviot;

        // Quick Sort on left side.
        quickSort(arr, start, left - 1);
        quickSort(arr, left+1, end);
        return arr;
    }

    private static void swapStartAndCur(int[] arr, int start, int cur) {
        int temp = arr[start];
        arr[start] = arr[cur];
        arr[cur] = temp;

    }

    public static void main(String[] args) {
        int[] input = new int[]{6,2,4,1,3};
        int[] res = quickSort(input, 0, input.length-1);
        System.out.println("res: ");
        if(res!=null)
            Arrays.stream(res).forEach(System.out::print);

    }
}

