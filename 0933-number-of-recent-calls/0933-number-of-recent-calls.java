import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {
    private final Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        // Step 1: Add new request timestamp
        queue.offer(t);

        // Step 2: Remove timestamps older than (t - 3000)
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        // Step 3: Remaining elements are within the [t - 3000, t] window
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */