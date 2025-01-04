package SlidingWindow;

import java.util.*;

public class LongestRepeatingCharacterReplacement {
    // "AAABABB", k = 1, output: 5
    public int characterReplacement(String s, int k) {
        // "XYYX", k=2
        int start = 0;
        int end = 0;
        int longest = 0;

        while(end < s.length()){
            longest =
            end++; // sliding window from start to end.
        }
        return 0;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        System.out.println(obj.characterReplacement("AAABABB", 1));;
    }
}
