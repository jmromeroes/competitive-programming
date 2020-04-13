import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    
    private int fromValidStringToInt(String integerAsString, char foundSymbol){
        //WE ASSUME STRING HAS ALREADY BEEN VERIFIED
        int lengthOfNumber = integerAsString.length();
        
        int j=0;
        int res=0;
        for(int i=lengthOfNumber-1; i>=0; i--){
            
            if(foundSymbol == '-') {
                res -= Math.pow(10, j)*Character.getNumericValue(integerAsString.charAt(i));
            } else {
                res += Math.pow(10, j)*Character.getNumericValue(integerAsString.charAt(i));
            }
            j++;
        }
        return res;
    }
    
    private boolean verifyIfLarger(String checkedNumber, String maxNumber) {
        //ASSUMMING BOTH HAVE SAME SIZE
        int j = 0;
        int i = checkedNumber.charAt(0) == '+'?1:0;
        
        for(; i<checkedNumber.length(); i++){
            if(checkedNumber.charAt(i) > checkedNumber.charAt(j)){
                return true;
            }
            j++;
        }
        
        return false;
    }
    
    private int getIntValueWithValidations(String integerAsString, char foundSymbol) {
        //WE ASSUME THE VALUE integerAsString IS A VALID STRING;
        
        int maxInteger = 2147483647;
        int minInteger = -2147483648;
                
        String maxIntegerString = Integer.toString(maxInteger);
        String minIntegerString = Integer.toString(minInteger);
        
        switch(foundSymbol){
            case '-':
                if(integerAsString.length() > minIntegerString.length()){
                    return minInteger;
                } else if(integerAsString.length() == minIntegerString.length()){
                    if(this.verifyIfLarger(integerAsString, minIntegerString)){
                        return minInteger;
                    }
                }
                break;
            case '+':
                if(integerAsString.length() > maxIntegerString.length() + 1){
                    return maxInteger;
                } else if(integerAsString.length() == minIntegerString.length() + 1){
                    if(this.verifyIfLarger(integerAsString, minIntegerString)){
                        return maxInteger;
                    }
                }
                break;
            default:
                if(integerAsString.length() > maxIntegerString.length()){
                    return maxInteger;
                } else if(integerAsString.length() == minIntegerString.length()){
                    if(this.verifyIfLarger(integerAsString, minIntegerString)){
                        return maxInteger;
                    }
                }
                break;
        }
        
        return fromValidStringToInt(integerAsString, foundSymbol);
    }
    
    public String removeInitialZeroes(String str) {
        int i=0;
        for(; i<str.length(); i++){
            if(str.charAt(i) != '0'){
                break;
            }
        }
        
        if(i == 0) {
            return str;
        } else if(i==str.length()){
            return "0";
        } else {
            return str.substring(i, str.length());
        }
    }
    
    public int myAtoi(String str) {
        Character[] validDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Character[] validSymbols = {'+', '-' };
                
        HashSet<Character> validDigitsSet = new HashSet(Arrays.asList(validDigits));
        HashSet<Character> validSymbolsSet = new HashSet(Arrays.asList(validSymbols));
        
        boolean initialDigitFound = false;
        char foundSymbol = '*';
        
        int startedIndex=-1;
        int finishedIndex=-1;
        
        for(int i = 0; i < str.length(); i++) {
            Character currentCharacter = new Character(str.charAt(i));
            
            if(validSymbolsSet.contains(currentCharacter) && !initialDigitFound && foundSymbol=='*'){
                if(i == str.length() - 1 || !validDigitsSet.contains(str.charAt(i+1))) {
                    return 0;
                } else {
                  foundSymbol=currentCharacter;
                  continue;
                }
            } else if(validDigitsSet.contains(currentCharacter)) {
                initialDigitFound = true;
                startedIndex = startedIndex==-1?i:startedIndex;
                finishedIndex = i;
            } else if(currentCharacter == ' ' && !initialDigitFound && foundSymbol=='*') {
                continue;
            } else {
                break;
            }
        }
                
        if(startedIndex == -1 || finishedIndex == -1) {
            return 0;
        } else {
            String numberSubstring = str.substring(startedIndex, finishedIndex+1);
            String numberAsString = removeInitialZeroes(numberSubstring);
            return this.getIntValueWithValidations(numberAsString, foundSymbol);
        }
        
    }
}
