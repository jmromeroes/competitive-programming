class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDifference = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                for(int h=j; h<nums.length; h++) {
                    if(h != j && h != i && j != i) {
                       int currVal = nums[h]+nums[j]+nums[i];
                       int absoluteValue = Math.abs((currVal)-target);
                       if(absoluteValue == 0){
                           return target;
                       } else if(absoluteValue < minDifference){
                         minDifference=absoluteValue; 
                         minValue=currVal;
                       } 
                    }
                }
            }
        }
	
        return minValue;
    }
}
