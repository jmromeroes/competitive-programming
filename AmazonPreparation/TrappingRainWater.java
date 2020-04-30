class Solution {
    public int trap(int[] height) {
        
        if(height.length <= 2) {
            return 0;    
        }
        
        int[] leftMaxHeights = new int[height.length];
        int[] rightMaxHeights = new int[height.length];
        
        // Fill leftMaxHeight
        for(int i=0; i<height.length-1; i++) {
            leftMaxHeights[i+1] = Math.max(height[i], Math.max(leftMaxHeights[i], height[i+1]));
            rightMaxHeights[height.length - i - 2] =  Math.max(height[height.length-1-i] , Math.max(rightMaxHeights[height.length-1-i], height[height.length-2-i]));
        }
        
        int totalWater = 0;
        for(int i=1; i<height.length-1; i++) {
            totalWater += Math.min(leftMaxHeights[i], rightMaxHeights[i]) - height[i];
        }
        
        return totalWater;
    }
}
