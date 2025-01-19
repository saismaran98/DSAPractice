package ArraysAndString;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ContainDuplicate {
    public boolean hasDuplicate(int[] nums){
        Set<Integer> uniqSet = new HashSet<>();
        for(Integer cur : nums){
            if(uniqSet.contains(cur))
                return false;
            uniqSet.add(cur);
        }
        return true;
    }
    public boolean isAnagram(String s, String t){
        if(s.length()!=t.length())
            return false;
      char[] sortedS = s.toCharArray();
      char[] sortedT = t.toCharArray();
        Arrays.sort(sortedS);
        Arrays.sort(sortedT);
        return Arrays.toString(sortedS).equals(Arrays.toString(sortedT));

    }
    public void twoSum( int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int index =0;
        for(Integer i : nums)
            map.put(i, index++);
        index=0;
        for(Integer num : nums){
           int comp= target-num;
            if(map.containsKey(comp)){
                System.out.println(num+","+ comp);

            }
            index++;
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        // not optimized
        if(strs==null || strs.length==0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        // List<String> anagram = new ArrayList<>();
        for(String s : strs) {
            char[] sortS = s.toCharArray();
            Arrays.sort(sortS);
            String key = new String(sortS);
            if(! map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if(strs==null || strs.length==0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        // List<String> anagram = new ArrayList<>();
        for(String s : strs) {
            // create a key with count of char
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                // create map key for this anagram key
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);

        }

        return new ArrayList<>(map.values());
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> bucket[] = new List[nums.length+1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=bucket.length-1;i>=0 && res.size()<k;i--){
            if(bucket[i]!=null)
                res.addAll(bucket[i]);
        }
        int[] topK = new int[k];
        for(int i =0;i<k;i++){
            topK[i]=res.get(i);
        }
        return topK;
    }
public static int[] topKSecondApproach(int[] nums, int k){
    Map<Integer, Integer> count = new HashMap<>();
    List<Integer>[] freqBucket = new List[nums.length + 1];
    int[] res = new int[k];
    //Get frequencey for each element in array ex.{1:3, 2:2, 3:2}
    for(Integer num: nums){
        count.put(num, count.getOrDefault(num, 0)+1);
    }
    for(int i =0;i<nums.length+1;i++){
        freqBucket[i]=new ArrayList<>();
    }
    // create a bucket of frequency to store the arrayList whose freq is n
    for(Map.Entry<Integer, Integer> freqMapRow : count.entrySet()){
        int num = freqMapRow.getKey();
        int freq = freqMapRow.getValue();
        freqBucket[freq].add(num); // { 1:[], 2:[2,3], 3:[1] }
    }

    int index =0;
    for(int i = freqBucket.length -1; i>0 && index <k; i--){
       if(freqBucket[i].size()>0) {
           for (int n : freqBucket[i]) {
               res[index++] = n;
               if (index == k)
                   return res;
           }
       }
    }
    return res;
}
    public static int[] topKFrequentUsingHeap(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

    public static void main(String[] args) {
        ContainDuplicate containDuplicate = new ContainDuplicate();
        System.out.println( containDuplicate.isAnagram("bac", "cab"));
        containDuplicate.twoSum(new int[]{ 2, 7, 11, 15},9);
        String[] input =new String[] {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(input);
        System.out.println(groupAnagrams2(input));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3,3,3},2 )));
        System.out.println(Arrays.toString(topKSecondApproach(new int[]{1, 1, 1, 2, 2, 3, 3, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequentUsingHeap(new int[]{1, 1, 1, 2, 2, 3, 3, 3}, 2)));
    }
}
