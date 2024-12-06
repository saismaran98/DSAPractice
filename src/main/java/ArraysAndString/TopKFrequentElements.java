package ArraysAndString;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/* Leetcode : medium */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        //1. count frequency of each element using hashMap
        HashMap<Integer, Integer> elementCount = new HashMap<>();
        calculateElementFrequencyAndPutInHashMap(nums, elementCount);

        //2.  Use a min-heap to keep track of the top k elements, priorityQueue use minHeap by default so when we poll(remove from minHeap) we always get smallest no. first.
        // each item in this priority queue is a Map<Integer, Integer>
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> Integer.compare(a.getValue(), b.getValue()));;
        keepTrackOfTopKElementUsingMinHeap(k, elementCount, minHeap);

        // Step 3: Extract the elements from the heap into an int[]
        return extractAndReturnElementFromMinHeap(k, minHeap);

    }

    private static void calculateElementFrequencyAndPutInHashMap(int[] nums, HashMap<Integer, Integer> elementCount) {
        for (Integer element : nums) {
            elementCount.put(element, elementCount.getOrDefault(element, 0) + 1);
        }
    }

    private static void keepTrackOfTopKElementUsingMinHeap(int k, HashMap<Integer, Integer> elementCount, PriorityQueue<Map.Entry<Integer, Integer>> minHeap) {
    /*
           1=3      (we compare the value count and put the lowest  count at top)
          /
         4=4
    */
        for(Map.Entry<Integer, Integer> entry: elementCount.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()> k){
                minHeap.poll();
            }
        }
    }

    private static int[] extractAndReturnElementFromMinHeap(int k, PriorityQueue<Map.Entry<Integer, Integer>> minHeap) {
        int[] result = new int[k];
        int index = 0;
        while ( !minHeap.isEmpty() ){
            result[index++] = minHeap.poll().getKey();
        }
        return result;
    }
}
