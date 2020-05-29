class Solution {
    private boolean isDecreasing(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i+1]){
                return false;
            }
        }
        
        return true;
    }
    
    private void swap(int[] nums, int i1, int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
    
    private void swapToNext(int[] nums){
        for(int i = nums.length-1; i > 0; i--){
            if(nums[i]>nums[i-1]){
               int minDifference = Integer.MAX_VALUE;
               int minDifferenceIndex = Integer.MAX_VALUE;
                
               for(int j = i; j < nums.length; j++){
                    if(nums[j] > nums[i-1]){
                        if(nums[j] == nums[i-1]+1){
                            swap(nums, i-1, j);
                            bubbleSort(nums, i, nums.length-1); 
                            return;
                        } else if(nums[j]-nums[i-1] < minDifference){
                            minDifferenceIndex=j;
                            minDifference = nums[j]-nums[i-1];
                        }
                    }
                }
                swap(nums, i-1, minDifferenceIndex);
                bubbleSort(nums, i, nums.length-1); 
                return;
            }
            
        }
    }
    
    private void bubbleSort(int[] nums, int start, int end){
        for(int i = 0; i < end-start; i++){
            for(int j = start; j < end-i; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }
    }
    
    public void nextPermutation(int[] nums) {
       if(isDecreasing(nums)){
           bubbleSort(nums, 0, nums.length-1);
       } else {
           swapToNext(nums);
       }
    }
}
