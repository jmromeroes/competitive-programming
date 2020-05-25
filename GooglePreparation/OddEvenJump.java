import java.util.*;

class Solution {
    
    private class RangeComparator implements Comparator<Integer> {
        int[] A;
        boolean increasing;
        
        RangeComparator(int[] A, boolean increasing){
            this.A = A;
            this.increasing = increasing;
        }
        
        @Override
        public int compare(Integer v1, Integer v2){
            return this.increasing?(this.A[v1]>=this.A[v2]?1:-1):(this.A[v1]<=this.A[v2]?1:-1);
        }
    }
    
    private int[] createNextValueArray(int[] A, boolean increasing){
        
        List<Integer> orderedList = IntStream.range(0, A.length).boxed().collect(Collectors.toList());
        orderedList.sort(
            new RangeComparator(A, increasing)
        );
        
        Stack<Integer> monotonicStack = new Stack();
        int[] nextValueArray = new int[A.length];
        
        for(int i=0; i<A.length; i++){
            if(!monotonicStack.isEmpty()){
                int topValue = monotonicStack.peek();
                int currValue = orderedList.get(i);
                
                boolean booleanFactor = currValue>orderedList.get(topValue);
                
                while(booleanFactor && !monotonicStack.isEmpty()){
                    nextValueArray[orderedList.get(monotonicStack.pop())] = orderedList.get(i);
                    if(!monotonicStack.isEmpty()) {
                        topValue = monotonicStack.peek();
                        booleanFactor = currValue>orderedList.get(topValue);
                    }
                }
            }
            
            monotonicStack.push(i);
        }
	
        return nextValueArray;
    }
    
    public int oddEvenJumps(int[] A) {
        int[] nextIncreasing = createNextValueArray(A, true);        
        int[] nextDecreasing = createNextValueArray(A, false);
        
        int res = 0;
        
        for(int i=0; i<A.length-1; i++){
            int currentJump = 1;
            int currentNext = nextIncreasing[i];
            
            while(currentNext != A.length-1 && currentNext != 0){
                currentJump++;
                if(currentJump % 2 == 0){
                    currentNext = nextDecreasing[currentNext];
                } else {
                    currentNext = nextIncreasing[currentNext];
                }
            }
            
            if(currentNext == A.length-1){
                res += 1;
            }
        }
        
        return res+1;
    }
    
}
