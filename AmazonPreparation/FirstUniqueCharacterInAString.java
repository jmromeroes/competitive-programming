class Solution {
    public int firstUniqChar(String s) {
        
        if(s.length() == 0){
            return -1;
        }
        
        int[] referenceArray = new int[28];
        int initialCode = Character.getNumericValue('a');
        
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            int indexInReference = Character.getNumericValue(currentChar) - initialCode;
            
            referenceArray[indexInReference] += 1;
        }
        
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            int indexInReference = Character.getNumericValue(currentChar) - initialCode;
            
            if(referenceArray[indexInReference] == 1){
                return i;
            }
        }
        
        return -1;
    }
}
