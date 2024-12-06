import ArraysAndString.CheckPermutation;
import ArraysAndString.StaticArray;
import ArraysAndString.isUnique;

import java.util.Arrays;


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

    public static void main(String[] args) {
        System.out.println("1. isUnique: " +
                "Is \"abc\" unique ?, output: "+isUnique.isUniqueUsingBitOperator("abc")); //true
        System.out.println("2. CheckPermutation: abc is permutation of cab?" +
                "\nisPermutation: " + CheckPermutation.isPermutation("abc", "cab")
                +"\nisPermutationForASCII: "+ CheckPermutation.isPermutationForASCII("abc", "cab")
                +"\nispermutationUsingHashMap: "+CheckPermutation.ispermutationUsingHashMap("abc ", "cab "));
        testStaticArray();
    }
}
