
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        
        HashMap<Character, Integer> alphabetReference = new HashMap();
        
        int maxLength = 1;
        int j = 0;
        
        if(s.length() == 0){
            return 0;
        }
        
        for(int i=0; i<s.length(); i++){    
            Character currentCharacter = new Character(charArray[i]);
            
            if(alphabetReference.containsKey(currentCharacter)){
                int previousIndex = alphabetReference.get(currentCharacter);
                for(; j<=previousIndex; j++) {
                    alphabetReference.remove(charArray[j]);
                }
                alphabetReference.put(currentCharacter, i);
                continue;
            } else {
                alphabetReference.put(currentCharacter, i);
            }
            
            if(i - j + 1 > maxLength) {
                maxLength = i - j + 1;
            }
            
        }
        
        return maxLength;
    }
}
