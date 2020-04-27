class Solution {
    public int jump(int[] nums) {
        
        if(nums.length <= 1) {
            return 0;
        }
        
        int maxSteps = nums[0];
        int maxPos = nums[0];
        int jumps = 1;
        
        for(int i=1; i<nums.length; i++){
            if(maxSteps < i){
                jumps++;
                maxSteps = maxPos;
            }
            
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        
        return jumps;
    }
}
