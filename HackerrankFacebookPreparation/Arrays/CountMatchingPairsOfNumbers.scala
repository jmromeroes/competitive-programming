import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._


object Result {
    
    // Complete the numberPairs function below.
    def numberPairs(n: Int, ar: Array[Int]): Int = {
        var a: Array[Int] = Array.ofDim[Int](101)
        var res = 0
        for(v <- ar){
            if(a(v) == 0){
                a(v) = 1
            } else {
                a(v) = 0
                res += 1
            }
        }
        
        res
    }
    
}
