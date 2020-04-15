import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;

class Solution {
    
    private String createStringKeyFromList(ArrayList<Integer> list) {
        String res = "";
        
        Collections.sort(list);
        for(int i: list) {
            res += Integer.toString(i);
        }
        
        return res;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> referenceMap = new HashMap<>();
        
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        
        //BUILD THE MAP referenceMap
        for(int i = 0; i<nums.length; i++){
            if(!referenceMap.containsKey(nums[i])){
                ArrayList<Integer> indexList = new ArrayList();
                indexList.add(i);
                
                referenceMap.put(nums[i], indexList);
            } else {
                referenceMap.get(nums[i]).add(i);
            }
        }
        
        //START WITH ITERATION
        for(int i = 0; i < nums.length; i++) {
            for(int j=i; j < nums.length; j++){
                if(j == i) {
                    continue;
                } else {
                    
                    //WEIRD EDGE CASE
                    if(nums[j] == 0 && nums[i] == 0 && hashSet.contains("000")) {
                        continue;
                    }
                    
                    int keyToLookFor = -1*(nums[i] + nums[j]);
                    if(referenceMap.containsKey(keyToLookFor)) {
                        for(int thirdTermIndex: referenceMap.get(keyToLookFor)){
                            if(thirdTermIndex != i && thirdTermIndex != j){
                                ArrayList<Integer> singleResultList = new ArrayList();
                                singleResultList.add(nums[i]);
                                singleResultList.add(nums[j]);
                                singleResultList.add(nums[thirdTermIndex]);
                                
                                String keyFromList = createStringKeyFromList(singleResultList);
                                if(!hashSet.contains(keyFromList)){
                                    hashSet.add(keyFromList);
                                    result.add(singleResultList);
                                    break;
                                }   
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
