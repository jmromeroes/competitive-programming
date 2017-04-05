object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        var score = new Array[Int](n);
        for(score_i <- 0 to n-1) {
           score(score_i) = sc.nextInt();
        }
        
        var min: Int = score(0)
        var max: Int = score(0)
        var tMin: Int = 0
        var tMax: Int = 0

        for(i <- 1 until score.size){
          if(score(i) < min){
            min = score(i)
            tMin += 1   
          } else if(score(i) > max){
            max = score(i) 
            tMax += 1
          }
        }
        
        println(s"$tMax $tMin")
    }
}
