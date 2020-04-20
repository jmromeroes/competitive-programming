import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        
        if(s=="" || t=="" || (t.length() > s.length())) {
            return "";    
        }
        
        HashMap<Character, Integer> substringReference = new HashMap<>();
        
        for(int i=0; i<t.length(); i++){
            int count = substringReference.getOrDefault(t.charAt(i), 0);
            substringReference.put(t.charAt(i), count + 1);
        }
        
        int leftPointer = 0;
        int rightPointer = 0;
        int required = substringReference.size();
        int formed = 0;
                
        HashMap<Character, Integer> completeWindowReference = new HashMap<>();
        
        int minLength = Integer.MAX_VALUE;
        int leftPointerResult = -1;
        int rightPointerResult = -1;
        
            
        while(rightPointer < s.length()) {
            
            int rightCount = completeWindowReference.getOrDefault(s.charAt(rightPointer),0);
            completeWindowReference.put(s.charAt(rightPointer), rightCount+1);
            
            int v1 = completeWindowReference.get(s.charAt(rightPointer));
            int v2 = substringReference.getOrDefault(s.charAt(rightPointer), -1);
            
            if(v2 == v1){
                formed++;
            }
                               
            while(formed == required) {
                if(rightPointer - leftPointer < minLength){
                    leftPointerResult=leftPointer;
                    rightPointerResult=rightPointer;
                    minLength = rightPointer - leftPointer;
                }

                int leftCount = completeWindowReference.get(s.charAt(leftPointer));
                completeWindowReference.put(s.charAt(leftPointer), leftCount-1);

                if(substringReference.containsKey(s.charAt(leftPointer)) && completeWindowReference.get(s.charAt(leftPointer)) < substringReference.get(s.charAt(leftPointer))) {
                    formed--;
                }

                leftPointer++;
            }

            rightPointer++;
        }
        
        
        if(leftPointerResult == -1 || rightPointerResult == -1) {
            
            return "";
        } else {
            return s.substring(leftPointerResult, rightPointerResult+1);
        }
        
    }
    
}
