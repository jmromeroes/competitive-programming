import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.math.BigInt

object Solution {
    // Complete the stepPerms function below.
    def stepPerms(n: Int): Int = {
        val a: Array[BigInt] = Array.ofDim[BigInt](36)
        a(0) = BigInt("1")
        a(1) = BigInt("2")
        a(2) = BigInt("4")

        for(i <- 3 until n){
            a(i) = a(i-1) + a(i-2) + a(i-3)
        }

        return (a(n - 1) % BigInt("10000000007")).toInt
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val s = stdin.readLine.trim.toInt

        for (sItr <- 1 to s) {
            val n = stdin.readLine.trim.toInt

            val res = stepPerms(n)

            printWriter.println(res)
        }

        printWriter.close()
    }
}
