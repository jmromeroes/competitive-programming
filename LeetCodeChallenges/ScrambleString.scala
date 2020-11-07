/*
Special thanks to Santiago Cano from the Cracking Algorithms Discord (@Scano)
 */

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map

object Solution {
    
    def isScrambleRec(s1: String, s2: String, b: Boolean): Boolean = {
        if(s1.length <= 1){
            return s1 == s2
        }
        
        for(i <- 1 until s1.length){
            val count: Array[Int] = Array.ofDim[Int](26)

            for(c <- s1){
                count(c - 'a') += 1
            }

            for(c <- s2){
                count(c - 'a') -= 1
            }

            var isAnagram = true
            for(v <- count){
                isAnagram = isAnagram && (v == 0)
            }
            
            if(isAnagram){
                if(isScrambleRec(s1.substring(0, i), s2.substring(0, i), false) && isScrambleRec(s1.substring(i, s1.length), s2.substring(i, s2.length), false)){
                    return true
                }
            }
            
        }
        
        if(b) return false
        isScrambleRec(s1, s2.reverse, true)
    }
    
    def isScramble(s1: String, s2: String): Boolean = {
        isScrambleRec(s1, s2, false)    
    }
    
}
