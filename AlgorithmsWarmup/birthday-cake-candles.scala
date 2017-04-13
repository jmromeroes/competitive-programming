object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in)
        var n = sc.nextInt()
        var height = new Array[Int](n)
        for(height_i <- 0 to n-1) {
           height(height_i) = sc.nextInt()
        }
        val max: Int = height.max
        println(height.count(_ == max))
    }

}
