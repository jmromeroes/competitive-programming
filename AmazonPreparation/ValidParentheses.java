import java.util.Stack;
import java.util.HashSet;

class Solution {
    
    private HashSet initializeOpeningParenthesesSet() {
        HashSet<Character> openingParenthesesSet = new HashSet();
        openingParenthesesSet.add('(');
        openingParenthesesSet.add('{');
        openingParenthesesSet.add('[');
        
        return openingParenthesesSet;
    }
    
    public boolean isValid(String s) {
        
        if(s.length()==1) {
            return false;
        }
        
        Stack<Character> openingParenthesesStack = new Stack();
        HashSet<Character> openingParenthesesSet = initializeOpeningParenthesesSet();
        
        for(int i=0; i<s.length(); i++){
            char currentChar = s.charAt(i);
            if(openingParenthesesSet.contains(currentChar)) {
                openingParenthesesStack.push(currentChar);   
            } else {
                if(openingParenthesesStack.size() == 0){
                    return false;
                }
                
                char parentheses = (char) openingParenthesesStack.pop();
                if(currentChar == ')' && parentheses != '('){
                    return false;
                } else if(currentChar == '}' && parentheses != '{'){
                    return false;
                } else if(currentChar == ']' && parentheses != '['){
                    return false;
                }
            }
        }
        
        if(openingParenthesesStack.size() != 0){
            return false;
        }
        
        return true;
    }
}
