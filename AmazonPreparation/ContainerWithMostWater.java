class Solution {
    public int maxArea(int[] height) {
        
        int heightsLength = height.length;
        
        int maxArea = 0;
        
        for(int i=0; i<heightsLength; i++) {
            for(int j=i; j<heightsLength; j++) {
                int calculatedArea = (j-i)*Math.min(height[j], height[i]);
                maxArea = calculatedArea > maxArea?calculatedArea:maxArea;
            }   
        }
        
        return maxArea;
    }
}
