import java.util.HashMap;

class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> referenceMap = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++){
            int currentNumber = nums[i];
            
            Integer referenceValue = new Integer(target - currentNumber);
            
            if(referenceMap.containsKey(referenceValue)) {
                result[0] = referenceMap.get(referenceValue).intValue();
                result[1] = i;
                break;
            } else {
                referenceMap.put(new Integer(currentNumber), new Integer(i));
            }
        }
        
        return result;
    }
    
}
