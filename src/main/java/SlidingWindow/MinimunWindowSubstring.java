package SlidingWindow;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimunWindowSubstring {

    public static String minWindow(String s, String t) {
        //count freq for t.
        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray())
            tCount.put(c, tCount.getOrDefault(c, 0)+1);

        int have = 0, need = tCount.size();
        int left =0, right = 0;
        int minLen = Integer.MAX_VALUE; // any len less than max is new min len.
        int[] res = {-1,-1};
        while( right < s.length() ){
            char cur = s.charAt(right);
            if(tCount.containsKey(cur)){ // track element count.
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if(window.get(cur).equals(tCount.get(cur)))
                    have+=1; // found match with tCount.

                //check we have all the element equal to tCount.
                while(have == need)
                //calculate the window.
                {
                    int winLen = right - left + 1;

                    if (winLen < minLen) {
                        //new minWindow found.
                        minLen = winLen;
                        res[0]=left;res[1]=right; //save new minLen indexes.
                    }
                    char leftChar = s.charAt(left);
                    if (tCount.containsKey(leftChar))
                    {
                        window.put(leftChar, window.get(leftChar) - 1); // decrement leftChar from window.
                        if(window.get(leftChar) < tCount.get(leftChar)) // if we break window condition window[left] >= tCount[left], decrement have.
                            have--;
                    }
                    left+=1; // slide left pointer until we get new min window or break valid window.
                }
            }

            right+=1; // slide window to the end.
        }
        return minLen == Integer.MAX_VALUE ? ""
                : s.substring(res[0], res[1] + 1); // return substring from left, right+1 ( as substring excludes right boundry so we add 1)
    }
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
