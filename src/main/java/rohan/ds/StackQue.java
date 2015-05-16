package rohan.ds;

import java.util.Stack;

public class StackQue {

    public boolean verifyBalance(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                stack.push('(');
            else if (str.charAt(i) == '{') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    return false;
                else
                    stack.push('{');
            } else if (str.charAt(i) == '[') {
                if (!stack.isEmpty() && (stack.peek() == '(' || stack.peek() == '{'))
                    return false;
                else
                    stack.push('[');
            } else if (str.charAt(i) == ')' && stack.pop() != '(')
                return false;
            else if (str.charAt(i) == '}' && stack.pop() != '{')
                return false;
            else if (str.charAt(i) == ']' && stack.pop() != '[')
                return false;
            else
                continue;
        }
        return true;
    }

}
