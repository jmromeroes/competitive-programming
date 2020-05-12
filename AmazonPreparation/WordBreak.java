import java.util.*;

class Solution {
    
    public boolean wordBreak(String s, int start, int end, int[][] dp, HashSet<String> wordDict) {
        if(start >= end){
            return true;
        }
        
        for(int i=start; i<end; i++){
            if(dp[start][i] == 0) {
                if(wordDict.contains(s.substring(start, i+1))){
                    
                    dp[start][i] = 1;
                    
                    if(wordBreak(s, i+1, end, dp, wordDict)){
                        return true;
                    }
                } else {
                    dp[start][i] = -1;
                }
            }
        }
                   
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size() == 0){
            return false;
        }
        
        int start = 0;
        int end = s.length();
        
        /**
            0: UNEVALUATED,
            1: TRUE,
            -1: FALSE
        */
        int[][] dp = new int[s.length()][s.length()];
        
        HashSet<String> wordDictSet = new HashSet();
        for(String word: wordDict){
            wordDictSet.add(word);    
        }
        
        return wordBreak(s, start, end, dp, wordDictSet);
    }
}
