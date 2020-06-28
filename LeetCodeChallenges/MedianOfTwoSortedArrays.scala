object Solution {
    
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        val short: Array[Int] = if(nums1.length < nums2.length) nums1 else nums2
        val long: Array[Int] = if(nums1.length >= nums2.length) nums1 else nums2
        
        var start = 0
        var end = short.length
        
        while(start <= end){
            val partitionShort = (start + end)/2
            val partitionLong = ((short.length + long.length + 1)/2) - partitionShort;
            
            println(start, end)
            if(partitionShort < end && long(partitionLong - 1) > short(partitionShort)){
                start += 1
            } else if(partitionShort > start && short(partitionShort-1) > long(partitionLong)){
                end -= 1
            } else {
                val maxLeft: Double = 
                    if(partitionShort == 0)
                        long(partitionLong - 1)
                    else if(partitionLong == 0)
                        short(partitionShort-1)
                    else
                        Math.max(long(partitionLong - 1), short(partitionShort-1))
                
                if((short.length + long.length) % 2 == 1)
                    return maxLeft
                
                val minRight: Double = 
                    if(partitionShort == short.length)
                        long(partitionLong)
                    else if(partitionLong == long.length)
                        short(partitionShort)
                    else
                        Math.min(long(partitionLong), short(partitionShort))
                
                return (minRight + maxLeft) / 2
            }
        }
        
        return 0
    }
    
}