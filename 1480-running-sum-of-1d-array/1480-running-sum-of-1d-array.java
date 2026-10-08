class Solution {
    public int[] runningSum(int[] nums) {
        // Start from the second element and add the previous element's value to it
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}