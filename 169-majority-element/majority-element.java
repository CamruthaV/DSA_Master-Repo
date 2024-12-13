class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        if(n == 1){
            return nums[0];
        }
        
        
        for(int i = 0 ; i < nums.length-1 ; i++){
            if(nums[i]==nums[i+1]){
                count++;
            }
            else{
                count = 0;
            }
            
            if(count >= n/2){
                return nums[i];
            }
        }
        return -1;
    }
}