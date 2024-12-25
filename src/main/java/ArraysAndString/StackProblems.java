package ArraysAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackProblems {

    public static boolean isValid(String inputString) {

        // ([{}])
        Map<Character, Character> closeToOpenMap = new HashMap<>();
        closeToOpenMap.put(')','(');
        closeToOpenMap.put('}','{');
        closeToOpenMap.put(']','[');
        Stack<Character> stack = new Stack<>();
        for (char c : inputString.toCharArray()) {
            if(closeToOpenMap.containsValue(c)){
                stack.push(c);
            }
            if(!stack.isEmpty()){
                Character top = stack.pop();
                if(closeToOpenMap.containsValue(c) && !closeToOpenMap.get(top).equals(c))
                    return false;
            }else{
                return false;
            }

        }

        return stack.isEmpty();
    }















    //validParentheses
    public static boolean validParentheses(String inputString){
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeParanMapToItsOpen = new HashMap<>();
        closeParanMapToItsOpen.put(')','(');
        closeParanMapToItsOpen.put('}','{');
        closeParanMapToItsOpen.put(']','[');

        for(Character c: inputString.toCharArray()){
            boolean isClosingParan = closeParanMapToItsOpen.containsKey(c);
            if(isClosingParan) {
                if (!stack.isEmpty() &&
                        stack.peek() == closeParanMapToItsOpen.get(c))
                    stack.pop(); //remove the open parantheses for the close param in string.
                else
                    return false;
            }
            else
                stack.push(c); //add open parantheses as its not present in the stack.
        }
        return stack.isEmpty();
    }
    public static boolean validParanApproach2(String s) {
        if (!(s.length() % 2 == 0)) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if (c == '{'){
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if ( c == '('){
                stack.push(')');
            } else if(stack.isEmpty() || stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println( isValid("]]"));
        System.out.println(validParentheses("(({[]}))"));
        System.out.println(validParanApproach2("(({[]}))"));
    }
}
class MinStack {

    ArrayList<Integer> stack;
    public MinStack() {
        stack = new ArrayList<Integer>();
    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
stack.remove(stack.size()-1);
    }

    public int top() {
    return stack.get(stack.size() -1);
    }

    public int getMin() {
        int min = stack.get(0);
        for (Integer i : stack){
        if(i<min)
            min=i;
}
        return min;
    }
}