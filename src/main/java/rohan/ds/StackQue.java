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

    public int[] findSpan(int[] arr) {
        int[] spans = new int[arr.length];
        int p;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()])
                stack.pop();
            if (stack.isEmpty())
                p = -1;
            else
                p = stack.peek();
            spans[i] = i - p;
            stack.push(i);
        }
        return spans;
    }

    public int findLargestRectangle(int[] arr) {
        Stack<Pair> stack = new Stack<>();
        int i = 0, local_max = 0, global_max = 0;
        while (i < arr.length) {
            if (stack.isEmpty() || arr[i] >= stack.peek().first) {
                Pair temp = new Pair(arr[i], i);
                stack.push(temp);
                i++;
            } else {
                Pair top = stack.pop();
                local_max = top.first * (stack.isEmpty() ? i : (i - 1 - stack.peek().second));
                if (global_max < local_max)
                    global_max = local_max;
            }
        }
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            local_max = top.first * (stack.isEmpty() ? i : (i - 1 - stack.peek().second));
            if (global_max < local_max)
                global_max = local_max;
        }
        return global_max;
    }

}
