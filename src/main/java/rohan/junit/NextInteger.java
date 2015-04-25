package rohan.junit;

import java.util.Stack;

public class NextInteger {

    Stack<Integer> stack = new Stack<>();

    public int[] getNextInt(int[] arr) {

        int[] ans = new int[arr.length];
        if (arr.length < 2)
            return ans;
        ans[arr.length - 1] = -1;
        stack.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < stack.peek()) {
                ans[i] = stack.peek();
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.pop();
                }
                ans[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(arr[i]);
            }
        }
        return ans;
    }
}
