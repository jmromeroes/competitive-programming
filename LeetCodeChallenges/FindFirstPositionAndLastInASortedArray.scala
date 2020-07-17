object Solution {
    def searchRange(nums: Array[Int], target: Int): Array[Int] = {
        if(nums.length == 0) return Array(-1,-1)
        if(nums.length == 1) return if(nums(0) == target) Array(0, 0) else Array(-1, -1)
        if(target < nums(0) || target > nums(nums.length - 1))
            return Array(-1, -1)
        
        var startBeginning = 0
        var endBeginning = nums.length - 1
        
        var startFinish = 0
        var endFinish = nums.length - 1
                
        var firstResult = if(target == nums(0)) 0 else -1
        var lastResult = if(target == nums(nums.length - 1)) nums.length - 1 else -1
        
        while(firstResult == -1 || lastResult == -1){
            val medianBeginning = (startBeginning + endBeginning) / 2
            
            val medianEnd = (startFinish + endFinish) / 2
            
            
            if(firstResult == -1){
                if(endBeginning - startBeginning == 1){
                    if(nums(startBeginning) == target)
                        firstResult = startBeginning
                    else if(nums(startBeginning) != target && nums(endBeginning) != target)
                        return Array(-1, -1)
                    else 
                        firstResult = startBeginning + 1
                } else if(nums(medianBeginning) > target){
                    endBeginning = medianBeginning
                } else if(nums(medianBeginning) < target){
                    startBeginning = medianBeginning
                } else if(nums(medianBeginning) == target){
                    if(nums(medianBeginning - 1) < target){
                        firstResult = medianBeginning
                    } else {
                        endBeginning = medianBeginning
                    }
                }
            }
            
            if(lastResult == -1){
                if(endFinish - startFinish == 1){
                    if(nums(endFinish) == target)
                        lastResult = endFinish
                    else
                        lastResult = endFinish - 1
                } else if(nums(medianEnd) > target){
                    endFinish = medianEnd
                } else if(nums(medianEnd) < target){
                    startFinish = medianEnd
                } else if(nums(medianEnd) == target){
                    if(nums(medianEnd + 1) > target){
                        lastResult = medianEnd
                    } else {
                        startFinish = medianEnd
                    }
                }
            }
            
        }
                
        
        return Array(firstResult, lastResult)
    }
}