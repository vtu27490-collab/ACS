class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0; // Pointer representing the top of the stack in pushed[]
        int j = 0; // Pointer for popped[]

        for (int val : pushed) {
            pushed[i] = val; // Push onto simulated stack

            while (i >= 0 && pushed[i] == popped[j]) {
                i--; // Pop from simulated stack
                j++;
            }
            i++; // Advance stack pointer for the next push
        }

        return i == 0;
    }
}