import java.io._
import java.math._
import java.security._
import java.text._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.mutable._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Solution {

    // Complete the countTriplets function below.
    def countTriplets(arr: Array[Long], r: Long): Long = {
        var triplet = 0
        val map: Map[Long, List[Int]] = Map()

        for(i <- 0 until arr.length){
            map.get(arr(i)) match {
                case None =>
                    map(arr(i)) = List(i)
                case Some(v) =>
                    map(arr(i)) = v :+ i
            }
        }

        for(i <- 0 until arr.length){
            for {
                v1 <- map.get(arr(i))
                v2 <- map.get(arr(i)*r)
                v3 <- map.get(arr(i)*r*r)
            } yield {
                for {
                    x <- List(i)
                    y <- v2.filter(v => x < v)
                    z <- v3.filter(v => y < v)
                } yield {
                    triplet += 1
                }
            }
        }

        return triplet
    }

    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val nr = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

        val n = nr(0).toInt

        val r = nr(1).toLong

        val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toLong)
        val ans = countTriplets(arr, r)

        printWriter.println(ans)

        printWriter.close()
    }
}
