object Solution {
    
    def lookForRotationIndex(nums: Array[Int]): Int = {
        for(i <- 1 until nums.length){
            if(nums(i) < nums(i - 1)) return i
        }
        
        0
    }
    
    def search(nums: Array[Int], target: Int): Int = {
        if(nums.length == 0) return -1
        if(nums.length == 1) return if(target == nums(0)) 0 else -1
        var start = 0
        var end = nums.length - 1
        val rotationIndex = lookForRotationIndex(nums)

        while(start <= end){
            val i = ((end + start) / 2)
            val index = (i + rotationIndex) % nums.length
            val tEnd = (end + rotationIndex) % nums.length
            val tStart = (start + rotationIndex) % nums.length
            
            if(nums(tEnd) == target) return tEnd
            else if(nums(tStart) == target) return tStart
            else if(end - start == 1){
                return if(target == nums(tEnd)) tEnd
                else if(target == nums(tStart)) tStart
                else -1
            } else if(nums(index) < target) {
                start = i
            } else if(nums(index) > target){
                end = i
            } else {
                return index
            }
        }
        
        -1
    }
}