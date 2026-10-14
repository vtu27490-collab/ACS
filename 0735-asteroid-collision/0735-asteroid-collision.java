import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int curr : asteroids) {
            boolean exploded = false;

            // Collision occurs only when top of stack moves right (> 0) and current moves left (< 0)
            while (!stack.isEmpty() && stack.peek() > 0 && curr < 0) {
                int top = stack.peek();

                if (top < -curr) {
                    // Top asteroid explodes, check next asteroid in stack
                    stack.pop();
                } else if (top == -curr) {
                    // Both asteroids explode
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    // Current asteroid explodes
                    exploded = true;
                    break;
                }
            }

            // Push current asteroid if it didn't explode
            if (!exploded) {
                stack.push(curr);
            }
        }

        // Convert stack to result array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}