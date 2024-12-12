class Solution {
    public int missingNumber(int[] nums) {
        int[] vector=new int[nums.length+1];
        Arrays.fill(vector,-1);
        for(int i=0;i<nums.length;i++){
            vector[nums[i]]=nums[i];
        }
        for(int i=0;i<nums.length+1;i++){
            if(vector[i]==-1){
                return i;
            }
        }
        return -1;
    }
}