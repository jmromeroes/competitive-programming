object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in)
        val n = sc.nextInt()
        val calories = new Array[Int](n)
        for(calories_i <- 0 to n-1) {
           calories(calories_i) = sc.nextInt()
        }
        
        println(
          calories.sortBy(-_).foldLeft((BigInt("0"), 0))((x, y) =>
            (x._1 + BigInt(y.toString)*BigInt("2").pow(x._2), x._2.toInt + 1)
          )._1
        )

    }

}
