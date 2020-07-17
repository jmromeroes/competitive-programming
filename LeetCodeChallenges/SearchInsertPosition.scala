object Solution {
    def searchInsert(nums: Array[Int], target: Int): Int = {
        if(nums.length == 0) return 0
        if(nums.length == 1) return if(target == nums(0) || target < nums(0)) 0 else 1
        if(nums(0) > target) return 0
        if(nums(nums.length - 1) < target) return nums.length
        
        var start = 0
        var end = nums.length - 1
        
        while(start < end){
            val med = (end + start) / 2
            
            if(end - start == 1){
                if(nums(start) == target){
                    return start
                } else if(nums(end) == target){
                    return end
                } else {
                    return if(nums(start) > target) start else end
                }
            } else if(nums(med) > target){
                end = med
            } else if(nums(med) < target){
                start = med
            } else {
                return med
            }
        }
        
        if(nums(start) > target) start else start + 1 
    }
}