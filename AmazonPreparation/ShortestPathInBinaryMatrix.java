class Solution {
    
    private class Node {
        int y;
        int x;
        int level;
        
        Node(int x, int y, int level){
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
    
    private void addToQueue(int x, int y, int level, int[][] grid, Queue queue){  
        if(x < 0 || x >= grid.length || y < 0 || y >= grid.length || grid[y][x] == 1 || grid[y][x] == -1){
            return;
        }
        queue.add(new Node(x, y, level));
        grid[y][x] = -1;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        LinkedList<Node> queue = new LinkedList();
        
        int n = grid.length;
        
        if(n == 0 || grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        
        queue.add(new Node(0,0,1));
        grid[0][0] = -1;
            
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            
            int level = curr.level;
            if(x == n - 1 && y == n - 1){
                return level;
            }
            
            addToQueue(x+1, y, level+1, grid, queue);
            addToQueue(x-1, y, level+1, grid, queue);
            addToQueue(x, y+1, level+1, grid, queue);
            addToQueue(x, y-1, level+1, grid, queue);
            addToQueue(x+1, y+1, level+1, grid, queue);
            addToQueue(x-1, y-1, level+1, grid, queue);
            addToQueue(x+1, y-1, level+1, grid, queue);
            addToQueue(x-1, y+1, level+1, grid, queue);
        }
        
        return -1;
    }
}
