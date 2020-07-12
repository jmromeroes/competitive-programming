object Solution {
    def removeDuplicates(nums: Array[Int]): Int = {
        if(nums.length == 0) return 0
        var res = 0
        var available = 0
        var map: Set[Int] = Set()
        var i = 0
        
        for(i <- 0 until nums.length){
            if(!map.contains(nums(i))){
                map += nums(i)
                nums(available) = nums(i)
                available+=1
                res += 1
            }
        }
        res
    }
}