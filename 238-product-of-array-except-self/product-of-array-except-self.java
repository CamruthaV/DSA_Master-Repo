class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        int val = 1;
        int f = 0;
        for(int x : nums) {
            if(x == 0){ 
                f ++;
                continue;
            }
            val = val * x;
        }

        if(f >= 2) return ans;

        for(int i = 0; i < nums.length; i++) {
            if(f == 1 && nums[i] == 0) {
                ans[i] = val;
                return ans;
            } else if(f == 0) {
                ans[i] = val / nums[i];
            }
        }   

        return ans;
    }
}