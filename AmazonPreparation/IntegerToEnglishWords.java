import java.util.HashMap;

class Solution {
    
    
    private HashMap<String, String> initMap() {    
        HashMap<String, String> intAsStringReference = new HashMap();
        intAsStringReference.put("0", "");
        intAsStringReference.put("00", "");
        intAsStringReference.put("1", "One");
        intAsStringReference.put("2", "Two");
        intAsStringReference.put("3", "Three");
        intAsStringReference.put("4", "Four");
        intAsStringReference.put("5", "Five");
        intAsStringReference.put("6", "Six");
        intAsStringReference.put("7", "Seven");
        intAsStringReference.put("8", "Eight");
        intAsStringReference.put("9", "Nine");
        intAsStringReference.put("10", "Ten");
        intAsStringReference.put("11", "Eleven");
        intAsStringReference.put("12", "Twelve");
        intAsStringReference.put("13", "Thirteen");
        intAsStringReference.put("14", "Fourteen");
        intAsStringReference.put("15", "Fifteen");
        intAsStringReference.put("16", "Sixteen");
        intAsStringReference.put("17", "Seventeen");
        intAsStringReference.put("18", "Eighteen");
        intAsStringReference.put("19", "Nineteen");
        intAsStringReference.put("20", "Twenty");
        intAsStringReference.put("30", "Thirty");
        intAsStringReference.put("40", "Forty");
        intAsStringReference.put("50", "Fifty");
        intAsStringReference.put("60", "Sixty");
        intAsStringReference.put("70", "Seventy");
        intAsStringReference.put("80", "Eighty");
        intAsStringReference.put("90", "Ninety");
        
        return intAsStringReference;
    }
    
    private String getNumberByLevel(
        String fullNumberAsString, 
        int level,
        HashMap<String, String> referenceMap
    ){
        
        int currentIndex = fullNumberAsString.length() - level;
        String currentChar = "" + fullNumberAsString.charAt(currentIndex);
        boolean isZero = currentChar == "0";
        char nextChar = ' ';
        char prevChar = ' ';
        char secondNextChar = ' ';
        
        if(!currentChar.equals("0")){
            switch(level) {
                case 1:
                    if(currentIndex != 0) {
                        prevChar = fullNumberAsString.charAt(currentIndex - 1);
                        if(prevChar == '1') {
                            return "";
                        }
                    }
                    return referenceMap.get(currentChar);
                case 2:
                    nextChar = fullNumberAsString.charAt(currentIndex+1);
                    if(currentChar.equals("1") && nextChar != '0') {
                        return referenceMap.get("" + currentChar + nextChar);
                    }
                    return referenceMap.get(currentChar + "0");
                case 3:
                    return referenceMap.get(currentChar) + " Hundred";
                case 4:
                    if(currentIndex != 0) {
                        prevChar = fullNumberAsString.charAt(currentIndex - 1);
                        if(prevChar == '1') {
                            return "";
                        }
                    }
                    return referenceMap.get(currentChar) + " Thousand";
                case 5:
                    nextChar = fullNumberAsString.charAt(currentIndex+1);
                    
                    if(currentChar.equals("1") && nextChar != '0') {
                        return referenceMap.get("" + currentChar + nextChar) + " Thousand";
                    } else if(nextChar == '0') {
                        return referenceMap.get(currentChar + "0") + " Thousand";
                    } else {
                        return referenceMap.get(currentChar + "0");
                    }
                case 6:
                    nextChar = fullNumberAsString.charAt(currentIndex+1);
                    secondNextChar = fullNumberAsString.charAt(currentIndex+2);
                    
                    if(nextChar == '0' && secondNextChar == '0') {
                        return referenceMap.get(currentChar) + " Hundred Thousand";
                    } else {
                        return referenceMap.get(currentChar) + " Hundred";
                    }
                case 7:
                     if(currentIndex != 0) {
                        prevChar = fullNumberAsString.charAt(currentIndex - 1);
                        if(prevChar == '1') {
                            return "";
                        }
                    }
                    return referenceMap.get(currentChar) + " Million";
                case 8:
                    nextChar = fullNumberAsString.charAt(currentIndex+1);
                    secondNextChar = fullNumberAsString.charAt(currentIndex+2);
                    if(currentChar.equals("1") && nextChar != '0') {
                        return referenceMap.get("" + currentChar + nextChar) + " Million";
                    } else if(secondNextChar == '0' || nextChar == '0'){
                        return referenceMap.get(currentChar + "0") + " Million";
                    } else {
                        return referenceMap.get(currentChar + "0");
                    }
                case 9:
                    nextChar = fullNumberAsString.charAt(currentIndex+1);
                    secondNextChar = fullNumberAsString.charAt(currentIndex+2);
                    
                    if(nextChar == '0' && secondNextChar == '0') {
                        return referenceMap.get(currentChar) + " Hundred Million";
                    } else {
                        return referenceMap.get(currentChar) + " Hundred";
                    }
                case 10:
                    return referenceMap.get(currentChar) + " Billion";
            }
        }
        
        return "";
    }
    
    public String numberToWords(int num) {
        
        if(num == 0) {
            return "Zero";
        }
        
        HashMap<String, String> referenceMap = initMap();
        String numAsString = Integer.toString(num);
        
        int level = 1;
        int length = numAsString.length();
        String res = "";
        
        for(int i=length - 1; i >= 0; i--){
            String currentChar = "" + numAsString.charAt(i);
            String numByLevel = getNumberByLevel(numAsString, level, referenceMap);
            if(numByLevel != ""){
              res =  numByLevel + (res.equals("")?"":" " + res);
            }
            level++;
        }
        
        return res;
    }
}
