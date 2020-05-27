import java.util.*;

class Solution {
    
    private String licenseKeyFormatting(String S, int groupSize, int currentIndex, int maxIndex, int groupIndex, String currentString){
        if(currentIndex > maxIndex){
            return currentString;
        }
        boolean lastCharInGroup = groupSize-1 == groupIndex;
        boolean lastCharInString = currentIndex != maxIndex;
        
        String currentChar = String.valueOf(S.charAt(currentIndex));
        currentChar = (lastCharInGroup && lastCharInString)?currentChar+"-":currentChar;
        
        groupIndex = lastCharInGroup?0:groupIndex+1;
        
        return licenseKeyFormatting(S, groupSize, currentIndex+1, maxIndex, groupIndex, currentString+currentChar);
    }
    
    public String licenseKeyFormatting(String S, int K) {
        
        S = S.replace("-", "").toUpperCase();
        
        if(S.length() == 1){
            return S;
        }
        
        int module = S.length() % K;
        int firstGroupSize = module==0?K:module;
        
        if(firstGroupSize == K){
            return licenseKeyFormatting(S, K, 0, S.length()-1, 0, "");  
        } else {
            return licenseKeyFormatting(S, module, 0, firstGroupSize-1, 0, "") + "-" + licenseKeyFormatting(S, K, firstGroupSize, S.length()-1, 0, ""); 
        }
        
    }
}
