package ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EncodeDecode {

    public static String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while(i<str.length()){
            int delIndex = str.indexOf('#',i);
            int strLen = Integer.parseInt(str.substring(i, delIndex));

            int startIndex = delIndex + 1;
            int endIndex = startIndex + strLen;
            String decodedString = str.substring(startIndex, endIndex);
            res.add(decodedString);
            i= endIndex;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(Arrays.asList("neet", "code", "love", "you"));
        String encodedString = encode(strs);
        System.out.println("encodedString: " + encodedString);
        System.out.println("decodedString:  " + decode(encodedString));
    }


}
