import scala.collection.mutable._;

object Solution {
    def numTriplets(nums1: Array[Int], nums2: Array[Int]): Int = {
        var res = 0
        
        var set1: Set[(Int, Int)] = Set()
        for(num <- 0 until nums1.length){
            val pow = Math.pow(nums1(num), 2).toDouble
            val set: Map[Int, Int] = Map()
            
            for(i <- 0 until nums2.length){
                if(pow % nums2(i) == 0 && set.contains((pow/(nums2(i))).toInt)){
                    if(!set1.contains((num, i))){
                        set1.add(num,i)
                        res += set((pow/(nums2(i))).toInt)
                    }
                }
                
                set.get(nums2(i)) match {
                    case None =>
                        set(nums2(i)) = 1
                    case Some(l) =>
                        set(nums2(i)) += 1
                }
            }
        }
        set1 = Set()
        
        var set2: Set[(Int, Int)] = Set()
        for(num <- 0 until nums2.length){
            val pow = Math.pow(nums2(num), 2).toDouble
            val set: Map[Int, Int] = Map()
            
            for(i <- 0 until nums1.length){
                if(pow % nums1(i) == 0 && set.contains((pow/nums1(i)).toInt)){
                    if(!set1.contains((num, i))){
                        set1.add(num,i)
                        res += set((pow/(nums1(i))).toInt)
                    }  
                }
                
                set.get(nums1(i)) match {
                    case None =>
                        set(nums1(i)) = 1
                    case Some(l) =>
                        set(nums1(i)) += 1
                }
            }
        }
        set2 = Set()
        res
    }
}
