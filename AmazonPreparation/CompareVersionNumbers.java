class Solution {
    
    private class StringRange {
        int start;
        int finish;
        
        StringRange(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
    private int createNumberFromString(String completeString, StringRange stringRange) {
        int res = 0;
        int level = 0;
        
        for(int i=stringRange.finish; i>= stringRange.start; i--){
            res += (Character.getNumericValue(completeString.charAt(i)))*(Math.pow(10, level));
            level++;
        }
        return res;
    }
    
    private StringRange getRangeFromPointStarting(String completeString, int startPoint) {
        
        if(startPoint >= completeString.length()){
            return null;
        } else {
            int finishPoint = startPoint;
            while(finishPoint + 1 < completeString.length() && completeString.charAt(finishPoint + 1) != '.') {
                finishPoint++;
            }
            return new StringRange(startPoint, finishPoint);
        }
    }
    
    public int compareVersion(String version1, String version2) {
        
        StringRange currentRangeV1 = getRangeFromPointStarting(version1, 0);
        StringRange currentRangeV2 = getRangeFromPointStarting(version2, 0);
        
        while(currentRangeV1 != null && currentRangeV2 != null) {
            int v1 = createNumberFromString(version1, currentRangeV1);
            int v2 = createNumberFromString(version2, currentRangeV2);
            
            if(v1 > v2) {
                return 1;
            } else if(v1 < v2) {
                return -1;
            }
            
            currentRangeV1 = getRangeFromPointStarting(version1, currentRangeV1.finish + 2);
            currentRangeV2 = getRangeFromPointStarting(version2, currentRangeV2.finish + 2);
        }
        
        if(currentRangeV1 == currentRangeV2) {
            return 0;
        } else if(currentRangeV1 == null) {
            while(currentRangeV2 != null){
                int v2 = createNumberFromString(version2, currentRangeV2); 
               
                if(v2 != 0) {
                    return -1;  
                }
                
                currentRangeV2 = getRangeFromPointStarting(version2, currentRangeV2.finish + 2);
            }
            
            return 0;
        } else {
            while(currentRangeV1 != null){
                int v1 = createNumberFromString(version1, currentRangeV1); 
                
                if(v1 != 0) {
                    return 1;  
                }
                currentRangeV1 = getRangeFromPointStarting(version1, currentRangeV1.finish + 2);
            }
            
            return 0;
        }
        
    }
}
