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

    // Complete the repeatedString function below.
    def repeatedString(s: String, n: Long): Long = {
        var res: Long = 0

        if(s.length > n){
            for(i <- 0 until n.toInt){
                if(s(i) == 'a') res += 1
            }
        } else {
            val numberOfBlocks: Long = Math.floor(n / s.length).toLong
            val rest = n % s.length

            for(i <- 0 until s.length){
                if(s(i) == 'a'){
                    res += numberOfBlocks

                    if(i < rest) res += 1
                }
            }
        }
        
        res
    }

}
