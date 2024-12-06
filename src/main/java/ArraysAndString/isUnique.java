package ArraysAndString;

import java.util.HashMap;
import java.util.HashSet;

// Impliment an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structure ?
public class isUnique {
    public static boolean isUniqueWithSet(String inputString){
        if(inputString.length() > 128)
            return false;
        char[] result = new char[inputString.length()+1];
        HashSet<Character> uniqueChars = new HashSet<>();
        for(Character c : inputString.toCharArray()){
            if(!uniqueChars.add(c))
                return false;
        }
        return true;
    }
    public static boolean checkUnique(String inputSring) {
        if(inputSring.length()>128)return false;
        boolean[] char_set= new boolean[128];
        for(int i = 0; i<inputSring.length();i++){
            int asciiValueOfChar=inputSring.charAt(i);
            if(char_set[asciiValueOfChar]) return false; //already present
            char_set[asciiValueOfChar]=true;
        }
        return true;
/*
Time Completxity: O(n), since we are looping still str.length() which is assumed n.
Space Complexity: O(1), since we are using fix size array!.
 */
    }

    //   Solution using bit operator which will reduce time complexity by factor of 8.
    // * Assumption all letters are lowerCase else we convert them to lower case to check.
    public static boolean isUniqueUsingBitOperator(String inputString){
        int checker = 0;
        for (Character c : inputString.toCharArray()){
            int shift = c - 'a';
            if((checker & 1 << shift) > 0)
                return false;
            checker |= (1<<shift);
        }
        return true;
    }
}