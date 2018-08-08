package algorithms;

import algorithms.stack.MinStack;
import org.junit.Test;

public class MainTest {

    @Test
    public void minStackTest() {
        MinStack obj = new MinStack();
        obj.push(-1);
        obj.push(-0);
        obj.push(-2);
        System.out.println(obj.peek());
        System.out.println(obj.getMin());
        System.out.println(obj.pop());
        System.out.println(obj.getMin());
    }
}
