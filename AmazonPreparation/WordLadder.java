// 34/45 cases passed => Time Limit Exeeded for the rest
import java.util.*;

class Solution {
    
    private class NodeInformation{
        String val;
        int level;
        
        NodeInformation(String val, int level){
            this.val = val;
            this.level = level;
        }
    }
    
    private boolean isDifferentByOne(String str1, String str2){
        int numberOfDifferences = 0;
        
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                if(numberOfDifferences == 1){
                    return false;
                }
                numberOfDifferences++;
            }
        }
        
        return true;
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<NodeInformation> queue = new LinkedList();
        Set<String> visitedWordsSet = new HashSet();
        
        if(wordList.size() <= 1){
            return 0;    
        }
        
        queue.add(new NodeInformation(beginWord, 1));
        visitedWordsSet.add(beginWord);
        
        while(queue.size() > 0){
            NodeInformation firstItem = queue.remove();
            for(String word: wordList) {
                if(!word.equals(firstItem) && !visitedWordsSet.contains(word)){
                    if(isDifferentByOne(word, firstItem.val)){
                        if(word.equals(endWord)){
                            return firstItem.level + 1;
                        }
                        
                        queue.add(new NodeInformation(word, firstItem.level + 1));
                    }
                }
            }
            
            visitedWordsSet.add(firstItem.val);
        }
        
        return 0;
    }

}
