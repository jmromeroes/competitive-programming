import java.util.HashMap;
import java.util.ArrayList;

class Solution {

    private String createHashFromString(String str) {
        int[] charReference = new int[28];
        int initialValue = Character.getNumericValue('a');
        
        for(int i=0; i<str.length(); i++) {
            charReference[Character.getNumericValue(str.charAt(i)) - initialValue] += 1;            
        }
        
        String hash = "";
        for(int i=0; i<28; i++){
            hash += Integer.toString(charReference[i]);
        }
        
        return hash;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashReference = new HashMap<>();
        List<String> listOfHashes = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        
        for(String str: strs){
            String hash = createHashFromString(str);
            
            if(hashReference.containsKey(hash)){
                hashReference.get(hash).add(str);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                hashReference.put(hash, stringList);
                listOfHashes.add(hash);
            }
        }
        
        for(String hash: listOfHashes) {
            result.add(hashReference.get(hash));
        }
        
        return result;
    }
    
}
