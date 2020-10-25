import scala.collection.mutable.Map
import scala.math.BigInt

object Solution {
    def slowestKey(releaseTimes: Array[Int], keysPressed: String): Char = {
        var prev = releaseTimes(0)
        var max = releaseTimes(0)
        var refVal: Char = keysPressed(0)
        
        for(i <- 1 until releaseTimes.length){
            val currTime = releaseTimes(i) - prev
            prev = releaseTimes(i)
            
            if(currTime > max){
                max = currTime
                refVal = keysPressed(i)
            } else if(currTime == max){
                if(refVal < keysPressed(i))
                    refVal = keysPressed(i)
            }
        }        
                
        refVal
    }
}
