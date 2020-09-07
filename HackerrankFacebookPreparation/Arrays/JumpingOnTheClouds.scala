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


    // Complete the jumpingOnClouds function below.
    def jumpingOnClouds(c: Array[Int]): Int = {
        var res = Int.MaxValue
        def jumpingOnClouds(c: Array[Int], i: Int, currJump: Int): Unit = {
            if(i == c.length - 1){
                res = Math.min(res, currJump)
            } else if(i < c.length - 1) {
                if(c(i) == 1) return
                jumpingOnClouds(c, i + 1, currJump+1)
                jumpingOnClouds(c, i + 2, currJump+1)
            }
        }
        jumpingOnClouds(c, 0, 0)
        res
    }

}

