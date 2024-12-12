class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashInt = new HashSet<>();
        for (int num:nums){
            if (!hashInt.add(num)){
                return true;
            }
        } 
        return false;
    }
}