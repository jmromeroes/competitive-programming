import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, Integer> map = new HashMap();
        
        for(int i =0; i<tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);    
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue((a, b) -> {return (int)b - (int)a;});
        queue.addAll(map.values());
        
        int res = 0;
        int numberEvaluated = 0;
        
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            
            for(int i=0; i<n+1; i++){
                if(!queue.isEmpty()){
                    list.add(queue.poll());
                    res++;
                    
                    numberEvaluated=n-i;
                }
                
            }
            
            
            for(Integer i: list){
                if(i-1 > 0){
                    queue.add(i-1);
                }
            }
            
            if(!queue.isEmpty()){
                res += numberEvaluated;
            }
        }
        
        return res;
    }
}
