class Solution {
    private int maxNumberOfFruits;
    
    public int totalFruit(int[] tree) {
        if(tree.length <= 2){
            return tree.length;
        }
        
        maxNumberOfFruits = 2;
        
        Integer firstType = tree[0];
        Integer secondType = null;
        int currNumberOfFruits = 1;
        int currLengthOfLastValue = 1;
        
        for(int i=1; i<tree.length; i++){
            Integer currentTree = tree[i];
                        
            if(
                (secondType == null && currentTree != firstType) || 
                (currentTree.equals(firstType) || currentTree.equals(secondType))
            ){  
                
                System.out.println("here1");
                 if(secondType == null && !currentTree.equals(firstType)){
                    currLengthOfLastValue = 1;
                    secondType = currentTree;
                } else if(currentTree.equals(secondType)){
                    currLengthOfLastValue++;
                } else if(secondType != null){
                    firstType = secondType;
                    secondType = currentTree;
                    currLengthOfLastValue=1;
                } else {
                    currLengthOfLastValue++;
                }
            
                currNumberOfFruits++;    
                
                maxNumberOfFruits = currNumberOfFruits>maxNumberOfFruits?currNumberOfFruits:maxNumberOfFruits;
                
            } else {
                if(!currentTree.equals(secondType) && !currentTree.equals(firstType)){
                    firstType = secondType;
                    secondType = currentTree;
                    currNumberOfFruits = currLengthOfLastValue+1;
                    currLengthOfLastValue = 1;
                } else if(!currentTree.equals(secondType)){
                    secondType = currentTree;
                    currNumberOfFruits = currLengthOfLastValue+1;
                    currLengthOfLastValue = 1;
                } else {
                    firstType = secondType;
                    secondType = currentTree;
                    currNumberOfFruits = currLengthOfLastValue+1;
                }
                
            }
            
            maxNumberOfFruits = currNumberOfFruits>maxNumberOfFruits?currNumberOfFruits:maxNumberOfFruits;
        }
        
        return maxNumberOfFruits;
    }
}
