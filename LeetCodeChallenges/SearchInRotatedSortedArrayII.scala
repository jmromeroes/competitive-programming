object Solution {
    
    def search(nums: Array[Int], target: Int, pivot: Int): Boolean = {
        var start = 0
        var end = nums.length
        
        while(end > start){
            val mid = (start + end) / 2
            
            val index = (mid + pivot) % nums.length
            val start_ = (start + pivot) % nums.length
            val end_ = (end + pivot) % nums.length
            
            if(end - start == 1){
                return nums(end_) == target || nums(start_) == target
            } else {
                if(nums(index) > target){
                    end = mid
                } else {
                    start = mid
                }
            }
        }
        
        val end_ = (end + pivot) % nums.length
        return nums(end_) == target 
    }
    
    def search(nums: Array[Int], target: Int): Boolean = {
        if(nums.length < 1) return false
        
        var pivot = nums.length - 1
        
        for(i <- nums.length - 1 to 0 by -1){
            if(i == 0){
                if(nums(pivot) > nums(0)){
                    pivot = 0
                }
            } else if(nums(i) <= nums(pivot) && nums(i - 1) != nums(i)){
              pivot = i
            }
        }
        search(nums, target, pivot)
    }
}
