object Solution extends App {

    def getDuplicationString(s: String, l: Int, n: Int): String = {
      if(l > n){
        s   
      } else {
        val sb: StringBuilder = new StringBuilder
        sb.append(s)
        for(c <- s){
          sb.append(if(c == '1') "0" else "1")
        }
        
        getDuplicationString(sb.toString, l*2, n)
      }
    }
  
    val sc = new java.util.Scanner (System.in)
    var q: Int = sc.nextInt
    var a0: Int = 0
      
    while(a0 < q){
        var x = sc.nextInt
        println(getDuplicationString("0", 1, x)(x))
        a0+=1
    }
}
