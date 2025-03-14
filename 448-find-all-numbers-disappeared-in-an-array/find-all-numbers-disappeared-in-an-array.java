class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] isAvailable = new boolean[nums.length];
        int n = nums.length;

        for (int i=0; i<n; i++){
            isAvailable[nums[i]-1] = true;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<isAvailable.length; i++){
            if (!isAvailable[i]){
                ans.add(i+1);
            }
        }
        return ans;
    }
}