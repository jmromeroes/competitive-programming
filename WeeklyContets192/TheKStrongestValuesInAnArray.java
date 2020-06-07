class Solution {
    
    private class MedianComparator implements Comparator<Integer> {
        int median;
        
        MedianComparator(int median){
            this.median = median;
        }
        
        @Override
        public int compare(Integer v1, Integer v2){
            float res = Math.abs(this.median - v2) - Math.abs(this.median - v1);
            return res != 0?(int)res:v2-v1;        
        }
    }
    
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length/2;
        List<Integer> sorted = Arrays.stream(arr).boxed().collect(Collectors.toList());
        sorted.sort((x, y) -> y-x);
        int median = sorted.get(n);
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new MedianComparator(median));
        
        for(int i: arr){
            priorityQueue.add(i);
        }
        
        System.out.println(priorityQueue);
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = priorityQueue.poll();
        }
        
        return res;
    }
}
