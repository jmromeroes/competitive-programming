class Solution {
    public boolean canJumpRecursive(int[] nums, int index, int[] evaluated){
        if(index >= nums.length-1){
            return true;
        }
        
        if(evaluated[index] != 0){
            return false;
        }
        
        evaluated[index] = 1;
        for(int i=index; i <= index+nums[index]; i++){
           if(canJumpRecursive(nums, i, evaluated)){
               return true;
           }
        }
        
        return false;
    }
    
    public boolean canJump(int[] nums) {
        if(nums.length <= 1){
            return true;
        }
        
        int[] evaluated = new int[nums.length];
        
        for(int i=0; i < nums[0]; i++){
           if(canJumpRecursive(nums, i, evaluated)){
               return true;
           }
        }
        return false;
    }
}
