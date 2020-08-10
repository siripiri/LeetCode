class Solution {
    public int findPeakElement(int[] nums) { 
        int res = 0;
        int maxPeak = Integer.MIN_VALUE;
        if(nums.length == 1){
            return 0;
        }
        if(nums[1] < nums[0]){
            res = 0;
            maxPeak = nums[0];
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i-1] < nums[i] && nums[i+1] < nums[i] && nums[i] > maxPeak){
                res = i;
                maxPeak = nums[i];
            }
        }
        if(nums[nums.length-2] < nums[nums.length-1]){
            if(nums[nums.length-1] > maxPeak){
                res = nums.length-1;
            }
        }
        return res;
    }
}