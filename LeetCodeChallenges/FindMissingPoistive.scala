object Solution {
    def firstMissingPositive(nums: Array[Int]): Int = {
        var foundOne = false
        for(i <- 0 until nums.length){
            if(nums(i) > nums.length || nums(i) <= 0){
                nums(i) = 1
            } else if(nums(i) == 1){
                foundOne = true
            }
        }
        
        if(!foundOne){
            return 1    
        }
        
        for(i <- 0 until nums.length){
            val index = Math.abs(nums(i)) - 1
            nums(index) = -Math.abs(nums(index))
        }
        
        for(i <- 0 until nums.length){
            if(nums(i) > 0)
                return i+1
        }
        
        return nums.length + 1
    }
}