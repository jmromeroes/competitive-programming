import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {


    // Complete the countingValleys function below.
    def countingValleys(n: Int, s: String): Int = {
        var res = 0;
        def countingValleys(s: String, height: Int, index: Int, isInValley: Boolean): Unit = {
            if(index >= s.length) return
            if(s(index) == 'D'){
                if(height - 1 < 0){
                    if(!isInValley) res += 1 
                    countingValleys(s, height - 1, index + 1, true)
                } else countingValleys(s, height - 1, index + 1, false)
            } else {
                if(height + 1 >= 0){
                    countingValleys(s, height + 1, index + 1, false)
                } else countingValleys(s, height + 1, index + 1, isInValley)
            }
        }

        countingValleys(s, 0, 0, false)
        res
    }


}
