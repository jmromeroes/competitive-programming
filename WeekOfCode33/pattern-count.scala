object Solution extends App{

  val sc = new java.util.Scanner (System.in)
  val q: Int = sc.nextInt
  var a0: Int = 0
          
  while(a0 < q){
    val s: String = sc.next
    val n: Int = s.size
    var patternStarted: Boolean = false
    var count: Int = 0
      
    for(i <- 0 until n){
      if(s(i) == '1'){
        if(patternStarted){
          if(i != 0 && s(i - 1) == '0')
            count += 1
        } else {
          patternStarted = true
        }
      } else if( s(i) != '0' ){
        patternStarted = false
      }  
    }
    
    println(count)
    a0+=1
  }
}
