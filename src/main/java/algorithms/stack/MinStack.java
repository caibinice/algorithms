package algorithms.stack;

/**
 * 最小值栈
 * Design a stack that supports push, pop, peek, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on peek of the stack.
 * peek() -- Get the peek element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.peek();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

public class MinStack {
    private int min = Integer.MAX_VALUE;
    private int thread = 10;
    private int[] stack;
    private int top = -1;

    /**
     * initialize data structure
     */
    public MinStack() {
        stack = new int[thread];
    }

    public void push(int x) {
        resize();
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if (x<=min) {
            top++;
            stack[top] = min;//存储上一个最小值
            min = x;
            resize();
        }
        top++;
        stack[top] = x;
    }

    public int pop() {
        if (top < 0) return -1;
        int val = stack[top];
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if (val == min) {
            top--;
            min = stack[top];//获取存储的上一个最小值
        }
        top--;
        return val;
    }

    public int peek() {
        if (top < 0) return -1;
        return stack[top];
    }

    public int getMin() {
        return min;
    }

    private void resize() {
        if (top >= thread - 1) {
            thread = 2 * thread;
            int[] newStack = new int[thread];
            for (int i = 0; i <= top; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.peek();
 * int param_4 = obj.getMin();
 */