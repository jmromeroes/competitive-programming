object Solution {
    def removeElement(nums: Array[Int], `val`: Int): Int = {
        var available: Int = 0
        
        for(i <- 0 until nums.length){
            if(nums(i) != `val`){
                nums(available) = nums(i)
                available += 1
            }    
        }
        available
    }
}