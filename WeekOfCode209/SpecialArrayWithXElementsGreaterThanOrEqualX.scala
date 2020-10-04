object Solution {
    def specialArray(nums: Array[Int]): Int = {
        if(nums.length == 0) return 0
        
        val numsList = nums.sorted
        val map: Map[Int, Int] = Map()
        
        println(nums.length)
        var res = -1;
        for(i <- 0 until nums.length - 1){
          val currLength = nums.length - i - 1
          if(currLength > numsList(i) && currLength <= numsList(i+1)){
             return currLength
          }
        }
        
        if(numsList(nums.length-1) == 0 && nums.length == 1){
            return 0
        }
        
        if(numsList(0) >= nums.length){
            return nums.length
        }
        -1
    }
}
