object Solution {
    def maxSubArray(nums: Array[Int]): Int = {
        if(nums.isEmpty) return 0
        if(nums.length == 1) return nums(0)
        
        
        val resArr: Array[Int] = new Array[Int](nums.length)
        resArr(0) = nums(0)
        var max: Int = resArr(0)
        
        for(i <- 1 until nums.length){
            val curr = resArr(i)
            resArr(i) = List(resArr(i-1)+nums(i), nums(i-1) + nums(i), nums(i)).max
            max = if(resArr(i) > max) resArr(i) else max
        }
        
        max
    }
}