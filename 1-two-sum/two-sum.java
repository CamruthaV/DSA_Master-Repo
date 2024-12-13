class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums[j] + nums[j - i] == target) {
                    return new int[] { j, j - i };
                }
            }
        }
        return null;
    }
}