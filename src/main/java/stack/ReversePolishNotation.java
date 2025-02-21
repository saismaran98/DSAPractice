package stack;

import java.util.Objects;
import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s=="+") {
                stack.push(stack.pop() + stack.pop()); // push addition to the stack
            } else if(Objects.equals(s, "-")){
                int value1 = stack.pop();
                int value2 = stack.pop();
                stack.push(value2 - value1);
            }

            else if(s=="*")
                stack.push(stack.pop() * stack.pop());
            else if(s=="/")
            {
                int value1 = stack.pop();
                int value2 = stack.pop();
                stack.push(value2 / value1);
            }

            else    //its a integer
                stack.push(Integer.valueOf(s));
        }
        return stack.pop();
    }

    public static void main(String[] args) {

    }
}
