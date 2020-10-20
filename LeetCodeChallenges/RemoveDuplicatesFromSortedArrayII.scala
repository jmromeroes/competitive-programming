object Solution {
    def swap(nums: Array[Int], index1: Int, index2: Int): Unit = {
        val temp = nums(index1)
        nums(index1) = nums(index2)
        nums(index2) = temp
    }
    
    def removeDuplicates(nums: Array[Int]): Int = {
        if(nums.length <= 2) return nums.length 
        
        var index = 1
        var newSize = 1
        var currentNumber = nums(0)
        var swapped = 1
        var currNumberOfRepeated = 1
        
        while(index < nums.length){
            println(nums.mkString(", "), index, swapped)
            
            if(nums(index) != currentNumber && swapped < index){
                currentNumber = nums(index)
                swap(nums, index, swapped)
                
                swapped = swapped + 1
                
                currNumberOfRepeated = 1
                index += 1
                if(swapped < nums.length && index < nums.length && nums(index) == currentNumber){
                    swap(nums, index, swapped)
                    index = index + 1
                    swapped = swapped + 1
                    currNumberOfRepeated = 2
                }
                newSize = swapped
            } else if(nums(index) == currentNumber && currNumberOfRepeated < 2){
                currNumberOfRepeated = 2
                swapped += 1
                if(newSize + 1 <= nums.length)
                    newSize += 1
                
                index += 1
            } else {
                if(nums(index) != currentNumber){
                    currentNumber = nums(index)
                    newSize = newSize + 1
                    swapped = index + 1
                    currNumberOfRepeated = 1
                } else if(currNumberOfRepeated < 2){
                    newSize = index + 1
                    newSize = newSize + 1
                    swapped = index + 1
                }
                index += 1
                
            }
        }
        
        Math.min(newSize, nums.length)
    }
}
