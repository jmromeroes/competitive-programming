import java.util.*;

class Solution {
    private class Pair{
        int dist;
        int x;
        int y;
        
        Pair(int dist, int x, int y){
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue((p1, p2) -> ((Pair)p1).dist-((Pair)p2).dist);
        int length = points.length;
        int[][] solution = new int[K][2];
        
        for(int i = 0; i < length; i++){
            int x = points[i][0];
            int y = points[i][1];
            
            priorityQueue.add(new Pair(x*x + y*y, x, y));
        }
        
        for(int i = 0; i < K; i++){
            Pair retrievedPair = priorityQueue.poll();
            solution[i] = new int[]{retrievedPair.x, retrievedPair.y};
        }
        
        return solution;
    }
}
