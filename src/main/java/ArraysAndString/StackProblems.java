package ArraysAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackProblems {

    //validParentheses
    public static boolean validParentheses(String inputString){
        Stack<Character> openParanStack = new Stack<>();
        Map<Character, Character> closeParanMapToItsOpen = new HashMap<>();
        closeParanMapToItsOpen.put(')','(');
        closeParanMapToItsOpen.put('}','{');
        closeParanMapToItsOpen.put(']','[');

        for(Character c: inputString.toCharArray()){
            if(closeParanMapToItsOpen.containsKey(c)) {
                if (!openParanStack.isEmpty() &&
                        openParanStack.peek() == closeParanMapToItsOpen.get(c))
                    openParanStack.pop(); //remove the open parantheses for the close param in string.
                else
                    return false;
            }
            else
                openParanStack.push(c); //add open parantheses as its not present in the stack.
        }
        return openParanStack.isEmpty();
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