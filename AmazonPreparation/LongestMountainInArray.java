class Solution {
    
    private enum SLOPE {
        Up,
        Down,
        Flat
    }
    
    public int longestMountain(int[] A){
        if(A.length < 3) {
            return 0;
        }
        
        SLOPE currentDirection = SLOPE.Flat;
        int largestMountainSize = 0;
        
        int currentSize = 1;
        
        if(A[0] < A[1]){
            currentDirection = SLOPE.Up;
        }
        
        for(int i=1; i<A.length; i++){
            int current = A[i];
            int previous = A[i-1];
            
            if(current > previous){
                if(currentDirection != SLOPE.Up) {
                    currentSize = 1;
                }
                
                currentDirection = SLOPE.Up;
                currentSize++;
            }
            
            if(current < previous){
                if(currentDirection != SLOPE.Flat) {
                    currentSize++;
                    if(currentSize > largestMountainSize) {
                        largestMountainSize=currentSize;
                    }
                    currentDirection = SLOPE.Down;
                }
            }
            
            if(current == previous) {
                currentSize = 1;
                currentDirection = SLOPE.Flat;
            }
        }
        
        return largestMountainSize;
    }
}
