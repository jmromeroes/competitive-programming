object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in)
        val n = sc.nextInt
        val p = sc.nextInt

        println(Math.min(p/2, (n - p)/2))        
    }
}
