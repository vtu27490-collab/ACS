import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    private Deque<Integer> inputStack;
    private Deque<Integer> outputStack;

    public MyQueue() {
        inputStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        shiftElements();
        return outputStack.pop();
    }

    public int peek() {
        shiftElements();
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    // Helper method to lazy-transfer elements when outputStack is empty
    private void shiftElements() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */