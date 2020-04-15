class Solution {
    
    private String generalConversion(int intValue, String minValue, String midValue, String largeValue) {
        String res = "";
        
        if(intValue == 0) {
            return "";    
        } else if(intValue >= 1 && intValue < 4) {
            for(int i=0; i<intValue; i++){
                res += minValue;
            }
            return res;
        } else if(intValue == 4){
            return minValue + midValue;
        } else if(intValue >= 5 && intValue < 9) {
            res += midValue;
            for(int i=0; i < intValue-5; i++){
                res += minValue;
            }
            return res;
        }
        
        return minValue + largeValue;
    }
    
    private String singleConversion(char numberAsChar, int currentLevel) {
        int intValue = Character.getNumericValue(numberAsChar);
        
        switch(currentLevel) {
            case 1:
                return this.generalConversion(intValue, "I", "V", "X");
            case 2:
                return this.generalConversion(intValue, "X", "L", "C");
            case 3:
                return this.generalConversion(intValue, "C", "D", "M");
            case 4: 
                String res = "";
                for(int i=0; i < intValue; i++) {
                    res += "M";
                }
                return res;
        }
        
        return "";
    }
    
    public String intToRoman(int num) {
        
        String intAsString = Integer.toString(num);
        String res = "";
        
        int j = 1;
        for(int i=intAsString.length() - 1; i >= 0; i--) {
            res = singleConversion(intAsString.charAt(i), j) + res;
            j++;
        }
        
        return res;
    }
}
