class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Shift all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill remaining positions with zeroes
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}