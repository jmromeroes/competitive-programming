import java.io._
import java.math._
import java.security._
import java.text._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import util.control.Breaks._
import scala.collection.mutable._

object Solution {
    var map: Map[(Int, Int), Array[Int]] = Map()

    def getHash(s: String, i1: Int, i2: Int): Array[Int] = {
        val a: Array[Int] = new Array[Int](28)

        for(i <- i1 to i2){
            a(s(i)-'a') += 1
        }

        a
    }

    def areAnagrams(s: String, i1: Int, i2: Int, j1: Int, j2: Int): Boolean = {
        
        val hash1 = map.get((i1,i2)) match {
            case None =>
                val hash = getHash(s, i1, i2)
                map((i1, i2)) = hash
                hash
            case Some(v) =>
                v
        }
        val hash2 = map.get((j1,j2)) match {
            case None =>
                val hash = getHash(s, j1, j2)
                map((j1, j2)) = hash
                hash
            case Some(v) =>
                v
        }

        for(i <- 0 until 28){
            if(hash1(i) != hash2(i))
                return false
        }

        return true
    }
    
    // Complete the sherlockAndAnagrams function below.
    def sherlockAndAnagrams(s: String): Int = {
        var res = 0
        for(range <- 0 to s.length - 1){
            for(inner <- 0 until (s.length - range - 1)){
                for(deep <- inner until (s.length - range)){
                    breakable {
                        if(inner == deep){
                            break
                        }

                        if(areAnagrams(s, inner, inner+range, deep, deep + range)){
                            res += 1
                        }
                    }
                }
            }
        }
        map = Map()
        return res
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val q = stdin.readLine.trim.toInt

        for (qItr <- 1 to q) {
            val s = stdin.readLine

            val result = sherlockAndAnagrams(s)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
