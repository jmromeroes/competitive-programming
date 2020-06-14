import java.io._
import java.math._
import java.security._
import java.text._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.mutable._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Solution {

    // Complete the freqQuery function below.
    def freqQuery(queries: Array[Array[Int]]): Array[Int] = {
        val res: ListBuffer[Int] = ListBuffer()
        val map: Map[Int, Int] = Map()
        val freqMap: Map[Int, Int] = Map()

        for(q <- queries){
            q(0) match {
                case 1 =>
                    if(map.contains(q(1))){
                        freqMap(map(q(1))) -= 1
                        map(q(1)) += 1

                        if(freqMap contains map(q(1)))
                            freqMap(map(q(1))) += 1
                        else
                            freqMap(map(q(1))) = 1
                    } else {
                        map(q(1)) = 1

                        if(freqMap contains 1)
                            freqMap(1) += 1
                        else
                            freqMap(1) = 1
                    }
                case 2 =>
                    if(map.contains(q(1))){   
                        val freq = map(q(1))                     
                        if(map(q(1)) >= 1){
                            if(freqMap(map(q(1))) >= 1)
                                freqMap(map(q(1))) -= 1

                            if(freqMap.contains(freq - 1))
                                freqMap(freq - 1) += 1
                            else
                                freqMap(freq - 1) = 1

                            map(q(1)) -= 1
                        }  
                    } 
                case 3 =>
                    if((freqMap contains q(1)) && freqMap(q(1)) != 0){
                        res += 1
                    } else {
                        res += 0
                    }
            }
        }

        println(map)
        println(freqMap)

        return res.toArray
    }

    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val q = StdIn.readLine.trim.toInt

        val queries = Array.ofDim[Int](q, 2)

        for (i <- 0 until q) {
            queries(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
        }

        val ans = freqQuery(queries)

        printWriter.println(ans.mkString("\n"))

        printWriter.close()
    }
}
