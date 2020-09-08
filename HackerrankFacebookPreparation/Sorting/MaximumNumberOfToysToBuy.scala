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


    // Complete the maximumToys function below.
    def maximumToys(prices: Array[Int], k: Int): Int = {
        val sorted: Array[Int] = prices.toList.sorted.toArray
        var res = 0
        var money = k
        while(res < prices.length){
            money -= sorted(res)
            res += 1

            if(money == 0){
                return res   
            } else if(money < 0){
                return res - 1
            }
        }

        res
    }

}
