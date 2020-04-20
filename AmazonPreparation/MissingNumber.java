class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedResult = (n * (n+1))/2;
        
        int sumOfNums = 0;
        
        for(int i=0; i<nums.length; i++) {
            sumOfNums += nums[i];
        }
        
        if(sumOfNums == expectedResult) {
            return 0;
        }
        
        return expectedResult-sumOfNums;
    }
}
