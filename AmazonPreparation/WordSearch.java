class Solution {
    
    private boolean exist(char[][] board, int x, int y, int currentIndex, String word, HashSet<String> usedCells){
        if(currentIndex >= word.length()){
            return true;
        }
        
        if(x < 0 || x >= board[0].length)
            return false;
        
        if(y < 0 || y >= board.length)
            return false;
        
        if(usedCells.contains(String.format("%d %d", x, y))){
           return false; 
        } 
        
        
        if(board[y][x] == word.charAt(currentIndex)){
            HashSet usedCells1 = new HashSet(usedCells);
            usedCells1.add(String.format("%d %d", x, y));
            HashSet usedCells2 = new HashSet(usedCells);
            usedCells2.add(String.format("%d %d", x, y));
            HashSet usedCells3 = new HashSet(usedCells);
            usedCells3.add(String.format("%d %d", x, y));
            HashSet usedCells4 = new HashSet(usedCells);
            usedCells4.add(String.format("%d %d", x, y));
            
            return 
                exist(board, x-1, y, currentIndex + 1, word, usedCells1) ||
                exist(board, x+1, y, currentIndex + 1, word, usedCells2) ||
                exist(board, x, y+1, currentIndex + 1, word, usedCells3) ||
                exist(board, x, y-1, currentIndex + 1, word, usedCells4);
        }
        
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0){
            return true;
        }
        
        if(board.length == 0 || board[0].length == 0){
            return false;
        }
        
        char firstChar = word.charAt(0);
        
        for(int y=0; y<board.length; y++){
            for(int x=0; x<board[0].length; x++){
                if(firstChar == board[y][x]){
                    HashSet usedCells = new HashSet();
                    usedCells.add(String.format("%d %d", x, y));
                    boolean valueFound = exist(board, x-1, y, 1, word, usedCells);
                    if(valueFound){
                        return true;
                    }
                    
                    usedCells = new HashSet();
                    usedCells.add(String.format("%d %d", x, y));
                    valueFound = exist(board, x+1, y, 1, word, usedCells);
                    if(valueFound){
                        return true;
                    }
                    
                    usedCells = new HashSet();
                    usedCells.add(String.format("%d %d", x, y));
                    valueFound = exist(board, x, y+1, 1, word, usedCells);
                    if(valueFound){
                        return true;
                    }
                    
                    usedCells = new HashSet();
                    usedCells.add(String.format("%d %d", x, y));
                    valueFound = exist(board, x, y-1, 1, word, usedCells);
                    if(valueFound){
                        return true;
                    }
                    
                }
            }
        }
        return false;
    }
}
