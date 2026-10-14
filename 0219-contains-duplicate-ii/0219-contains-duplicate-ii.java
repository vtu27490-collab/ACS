import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Found a duplicate within window size k
            if (window.contains(nums[i])) {
                return true;
            }

            window.add(nums[i]);

            // Maintain window size <= k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }
}