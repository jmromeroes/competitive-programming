object Solution {

  def getExpression(data: Array[BigInt], v: BigInt, op: Char, i: Int, n: Int): (String, Boolean) = {
    if (i == n - 1){
      if(op == '*'){
        if((v * data(i)).mod(BigInt("101")).equals(BigInt("0")))
          ("*"+data(i), true)
        else
          ("", false)
      } else if(op == '+') {
        if ((v + data(i)).mod(BigInt("101")).equals(BigInt("0")))
          ("+"+data(i), true)
        else
          ("", false)
      } else
        if ((v - data(i)).mod(BigInt("101")).equals(BigInt("0")))
          ("-"+data(i), true)
        else
          ("", false)        
    } else {
      
        if(op == ' '){      
          var h = getExpression(data, data(i), '*', i + 1, n)
          if(h._2)
            return (data(i).toString + h._1, true)
            
          h = getExpression(data, data(i), '+', i + 1, n)
          if(h._2)
            return (data(i).toString + h._1, true)
              
          h = getExpression(data, data(i), '-', i + 1, n)
          if(h._2)
            return (data(i).toString + h._1, true)
          
          (" ", false)
        } else if (op == '*') {
          var h = getExpression(data, v * data(i), '*', i + 1, n)
          if(h._2)
            return ("*"+data(i).toString + h._1, true)
            
          h = getExpression(data, v * data(i), '+', i + 1, n)
          if(h._2)
            return ("*"+data(i).toString + h._1, true)
              
          h = getExpression(data, v * data(i), '-', i + 1, n)
          if(h._2)
            return ("*"+data(i).toString + h._1, true)
          
          (" ", false)
        } else if(op == '+'){
          var h = getExpression(data, v + data(i), '*', i + 1, n)
          if(h._2)
            return ("+"+data(i).toString + h._1, true)
            
          h = getExpression(data, v + data(i), '+', i + 1, n)
          if(h._2)
            return ("+"+data(i).toString + h._1, true)
              
          h = getExpression(data, v + data(i), '-', i + 1, n)
          if(h._2)
            return ("+"+data(i).toString + h._1, true)
          
          (" ", false)
        } else {
          var h = getExpression(data, v - data(i), '*', i + 1, n)
          if(h._2)
            return ("-"+data(i).toString + h._1, true)
            
          h = getExpression(data, v - data(i), '+', i + 1, n)
          if(h._2)
            return ("-"+data(i).toString + h._1, true)
              
          h = getExpression(data, v - data(i), '-', i + 1, n)
          if(h._2)
            return ("-"+data(i).toString + h._1, true)
          
          (" ", false)
        }
      } 
    }
  
    def main(args: Array[String]) {
      val sc = new java.util.Scanner(System.in);
      val n: Int = sc.nextInt
      val a: Array[BigInt] = new Array[BigInt](n)
        
      for(i <- 0 until n){
        a(i) = BigInt(sc.next)
      }
      
      println(getExpression(a, BigInt("0"), ' ', 0, n)._1)
    }
}
