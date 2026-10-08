class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        
        // Build the prefix sum array
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            // Left sum contribution
            int leftSum = prefixSum[i] - nums[i];
            int leftCount = i;
            int leftTotal = (nums[i] * leftCount) - leftSum;
            
            // Right sum contribution
            int rightSum = prefixSum[n - 1] - prefixSum[i];
            int rightCount = n - 1 - i;
            int rightTotal = rightSum - (nums[i] * rightCount);
            
            result[i] = leftTotal + rightTotal;
        }
        
        return result;
    }
}