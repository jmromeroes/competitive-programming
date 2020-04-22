import java.util.HashSet;
import java.util.HashMap;
import java.util.stream.*;

class Solution {
    
    private String cleanWord(String word){
        return word.toLowerCase()
            .replace(",", " ")
            .replace("?", " ")
            .replace("'", " ")
            .replace(",", " ")
            .replace("!", " ")
            .replace(";", " ")
            .replace(".", " ")
            .replace("  ", " ");
    }
    
    public String mostCommonWord(String paragraph, String[] banned){
        HashSet<String> bannedSet = new HashSet();
        
        paragraph = cleanWord(paragraph);
        for(int i=0; i<banned.length; i++){
            bannedSet.add(cleanWord(banned[i]));
        }
        
        List<String> curedParagraphWordsList = 
            Arrays.asList(paragraph.split(" ")).stream().map(word -> {
                return word;
            }).filter(word -> {
                return !bannedSet.contains(word);    
            }).collect(Collectors.toList());
        
        int maxRepeatedWordTimes = 0;
        String maxRepeatedWord="";
        HashMap<String, Integer> countMap = new HashMap();
        for(String str: curedParagraphWordsList){
            int countOfString = countMap.getOrDefault(str, 0);
            countMap.put(str, countOfString + 1);
            if(countOfString + 1 > maxRepeatedWordTimes){
               maxRepeatedWord = str;
               maxRepeatedWordTimes = countOfString + 1;
            }
        }
        
        return maxRepeatedWord;
    }
}
