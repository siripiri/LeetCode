class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int temp = target - nums[i];
            if(hash.containsKey(temp)){
                int[] res = {hash.get(temp),i};
                return res;
            }
            hash.put(nums[i],i);
        }
        int[] res = {0,0};
        return res;
    }
}