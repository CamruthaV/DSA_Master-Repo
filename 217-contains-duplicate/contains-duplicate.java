class Solution {
    public boolean containsDuplicate(int[] nums) {
        int temp;
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
            temp = nums[i];
            if(nums[i]<nums[i-1]){
                for(int j=i-2; j>=0; j--){
                    if(nums[j]==temp){
                        return true;
                    }
                }
                nums[i] = nums[i-1];
                nums[i-1]=temp;
            }
        }
        return false;
    }
}