class Solution {
    public void moveZeroes(int[] nums) {
        int  i = 0;
    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != 0) {
            if (i != j) { // Swap only if i and j are different
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            i++;
        }
    }
    }
}