class Solution {
    public int findMajority(int[] nums){
        int canditate = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(canditate == nums[i]){
                count ++;
            }
            else{
                count --;
            }
            if(count == 0){
                canditate = nums[i];
                count = 1;
            }
        }
        return canditate;
    }
    public int majorityElement(int[] nums) {
        int canditate = findMajority(nums);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(canditate == nums[i]){
                count++;
            }
        }
        if(count > nums.length/2){
            return canditate;
        }
        return -1;
    }
}