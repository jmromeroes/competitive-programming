class Solution {
    private int[] addOneAtBeginning(int[] digits){
        int[] res = new int[digits.length+1];
        for(int i=0; i<digits.length; i++){
            res[i+1] = digits[i]; 
        }
        
        res[0] = 1;
        return res;
    }
    
    public int[] plusOne(int[] digits) {
        if(digits.length == 0){
            return new int[0];
        }
        
        boolean shouldUpdateBack = true;
        int index = digits.length-1;
        
        while(shouldUpdateBack && index >= 0){
            if(digits[index] == 9){
                digits[index] = 0;
            } else {                
                digits[index] = digits[index]+1;
                shouldUpdateBack = false;
            }
            
            index--;
        }
        
        if(shouldUpdateBack){
            return addOneAtBeginning(digits);
        }
        
        return digits;
    }
}
