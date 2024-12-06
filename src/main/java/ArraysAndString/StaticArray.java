package ArraysAndString;

public class StaticArray {
    // lenght = no. of real values in arr, capacity is the size for fixed array ex. arr[20], 20 is capacity.
    public void insertEnd(int[] arr, int n, int length, int capacity){
        if(length < capacity)
            arr[length] = n;
    }
    public void removeEnd(int[] arr, int arrLength){
        if(arrLength > 0) {
            arr[arrLength--] = 0;
            arrLength--; // reduce length by 1.
        }
    }

    /**
     * Inserts a value into a specific index of an array, shifting elements to the right.
     *
     * @param arr The array where the value will be inserted.
     * @param index The position at which the value should be inserted.
     * @param value The value to insert into the array.
     * @param currentLength The current number of elements in the array.
     *                      It is assumed the array has space for one more element.
     */
    public void insertMiddle(int[] arr, int index, int value, int currentLength) {
        // Shift elements to the right, starting from the last element down to the target index.
        for (int i = currentLength - 1; i >= index; i--) {
            arr[i + 1] = arr[i]; // Move each element one position to the right.
        }

        // Insert the new value at the specified index.
        arr[index] = value;
    }
    /**
     * Removes a value from a specific index in the array and shifts subsequent elements to the left.
     *
     * @param arr The array from which the value will be removed.
     * @param index The position of the value to be removed.
     * @param currentLength The current number of elements in the array.
     */
    public void removeMiddle(int[] arr, int index, int currentLength) {
        // Shift elements to the left, starting from the element after the target index.
        for (int i = index + 1; i < currentLength; i++) {
            arr[i - 1] = arr[i]; // Move each element one position to the left.
        }

        // Optionally, clear the last element (not necessary in most cases).
        arr[currentLength - 1] = 0; // Reset the last element.
    }



}
