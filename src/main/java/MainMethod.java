import ArraysAndString.CheckPermutation;
import ArraysAndString.StaticArray;
import ArraysAndString.isUnique;

import java.util.Arrays;
import java.util.List;


public class MainMethod {
    public static void testStaticArray(){
        System.out.println("inside testStaticArray()");
        StaticArray staticArray = new StaticArray();

        // Define the array and its properties
        int capacity = 10;
        int[] arr = new int[capacity]; // Array with a fixed capacity of 10
        int length = 0; // Initially, the array is empty

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(arr));

        // Test insertEnd
        staticArray.insertEnd(arr, 5, length++, capacity); // Insert 5 at the end
        staticArray.insertEnd(arr, 10, length++, capacity); // Insert 10 at the end
        staticArray.insertEnd(arr, 15, length++, capacity); // Insert 15 at the end
        System.out.println("\nArray after inserting at the end:");
        System.out.println(Arrays.toString(arr));;

        // Test insertMiddle
        staticArray.insertMiddle(arr, 1, 20, length++); // Insert 20 at index 1
        System.out.println("\nArray after inserting 20 at index 1:");
        System.out.println(Arrays.toString(arr));

        // Test removeMiddle
        staticArray.removeMiddle(arr, 2, length--); // Remove the element at index 2
        System.out.println("\nArray after removing element at index 2:");
        System.out.println(Arrays.toString(arr));

        // Test removeEnd
        staticArray.removeEnd(arr, length--); // Remove the last element
        System.out.println("\nArray after removing the last element:");
        System.out.println(Arrays.toString(arr));
    }

    public long sum(long n){
        int sum = 0;
        // check for s num
        for(int i = 0;i < n;i++) {
            if (isSNum(i))
                sum += i;
        }
        return sum;
    }
    public boolean isSNum(long l){
        double sqrt = Math.sqrt(l);
        // for for T(N) 1..N size of L
        return false;
    }
    public static void main(String[] args) {
        /*
        * We define an S-number to be a natural number, n, that is a perfect square
        * and its square root can be obtained by splitting the decimal representation
        *  of n into 2 or more numbers then adding the numbers.



For example, 81 is an S-number because

sq.rt of 81 = 8 + 1



6724 is an S-number:

sq.rt of 6724 = 6 + 72 + 4



8281 is an S-number:

sq.rt of 8281 = 8 + 2 + 81 = 82 + 8 + 1



9801 is an S-number:

sq.rt of 9801 = 98 + 0 + 1.



Further we define T(N) to be the sum of all S numbers (n le N). You are given T(10 pow 4) =41333.

Find T(10 pow 12).
        * */


    }

}
