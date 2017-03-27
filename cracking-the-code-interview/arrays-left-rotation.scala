object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        val n = sc.nextInt();
        val k = sc.nextInt();
        val a = new Array[Int](n);
        for(a_i <- 0 until n) {
           a(a_i) = sc.nextInt();
        }
        
        //Rotation Index
        var ri: Int = 0
        for(k_i <- 0 until k){
            ri += 1
            if(ri >= n)
                ri = 0
        }
        
        //Writing index
        var wi: Int = ri
        for(w_i <- 0 until n){
            wi += 1
            print(s"${a(wi - 1)} ")
            if(wi >= n)
              wi = 0            
        }
    }
}
