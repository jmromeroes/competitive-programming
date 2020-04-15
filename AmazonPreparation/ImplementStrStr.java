class Solution {
    
    private boolean checkIfSubstringFromSpecificIndexes(String haystack, int indexString, String needle){
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        
        for(int i=0; i<needle.length(); i++){
            if(i+indexString==haystackLength){
                return false;
            } else if(haystack.charAt(i+indexString) != needle.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
    
    public int strStr(String haystack, String needle) {
        int result=-1;
        
        if(needle.length() == 0) {
            return 0;
        }
        
        for(int i=0; i<haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(checkIfSubstringFromSpecificIndexes(haystack, i, needle)){
                    return i;
                }
            }
        }
        
        return result;
    }
}
