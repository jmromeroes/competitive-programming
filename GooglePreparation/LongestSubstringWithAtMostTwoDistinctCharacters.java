class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap();
        HashSet<Character> set = new HashSet();
        
        if(s.length() <= 2){
            return s.length();
        }
        
        Character firstCharType = s.charAt(0);
        set.add(firstCharType);
        map.put(firstCharType, 1);
    
        int max = 0;
        int start = 0;
        int end = 1;
        
        while(end < s.length()){
            Character endChar = s.charAt(end);
            
            if(set.size() == 1 && !set.contains(endChar)){
                set.add(endChar);
                map.put(endChar, 0);
            }
            
            if(set.size() > 1 && !set.contains(endChar)){
                if(end - start > max){
                    max = end - start;
                }
                
                boolean shouldRemove = true;
                while(shouldRemove){
                    char startChar = s.charAt(start);
                    
                    System.out.println(map);
                    System.out.println(startChar);
                    
                    int currValue = map.get(startChar);
                    map.put(startChar, currValue - 1);
                    if(map.get(startChar) == 0){
                        map.remove(startChar);
                        set.remove(startChar);
                        shouldRemove = false;
                    }
                    
                    start++;
                }
                
                set.add(endChar);
                map.put(endChar, 0);
            }
            
            if(set.contains(endChar)){
                map.put(endChar, map.get(endChar) + 1);
            }
            
            end++;
        }
        
        if(end - start > max){
            max = end - start;
        }
        
        return max;
    }
}
