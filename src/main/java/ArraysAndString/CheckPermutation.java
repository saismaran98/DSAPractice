package ArraysAndString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    // Given two strings, write a method to if one is permutation of other.
    public static String sort(String inputString){
        char[] content = inputString.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    public static boolean isPermutation(String firstString, String secondString){
       if(firstString.length()!=secondString.length())
           return false;
       return sort(firstString).equals(sort(secondString));
    }

    public static boolean ispermutationUsingHashMap(String first, String second){
        Map<Character, Integer> charCount =  new HashMap<>();
        for(char c: first.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c,0) +1); // charCount('a', 1)
        }
        for(char c: second.toCharArray()){
            if(!charCount.containsKey(c) || charCount.get(c)==0)
                return false;
            charCount.put(c, charCount.getOrDefault(c,0) -1);
        }
        return true;
    }

    public static boolean isPermutationForASCII(String s, String t){
        int[] charCount = new int[128]; // Assuming ASCII
        for (char c : s.toCharArray()) {
            charCount[c]++;
        }
        for (char c : t.toCharArray()) {
            charCount[c]--;
            if (charCount[c] < 0) {
                return false;
            }
        }
        return true;
    }

}
