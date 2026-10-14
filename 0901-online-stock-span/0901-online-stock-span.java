import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    // Stack stores pairs: int[]{price, accumulatedSpan}
    private final Deque<int[]> stack;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;

        // Pop elements while top price is less than or equal to current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        // Push current price and its accumulated span
        stack.push(new int[]{price, span});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */