class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        LinkedList<Integer> list = new LinkedList();
        
        for(int i = 0; i < n; i++){
            list.add(nums[i]);
            list.add(nums[n+i]);
        }
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = list.poll();
        }
        
        return nums;
    }
}
