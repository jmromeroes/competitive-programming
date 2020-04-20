class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        
        if(nums.length == 1){
            int[] res = {1};
            return res;  
        }
        
        for(int i = 1; i < leftProduct.length; i++) {
            if(i == 1){
                leftProduct[0] = 1;
            }
            leftProduct[i] = leftProduct[i-1]*nums[i-1];
        }
        
        for(int i=rightProduct.length - 2; i >= 0; i--) {
            if(i == rightProduct.length - 2){
                rightProduct[rightProduct.length - 1] = 1;
            }
            rightProduct[i] = rightProduct[i+1]*nums[i+1];
        }
        
        for(int i=0; i < nums.length; i++){
            nums[i] = leftProduct[i]*rightProduct[i];
        }
        
        return nums;
    }
}
