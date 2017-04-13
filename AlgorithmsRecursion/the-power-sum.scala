oobject Solution {
    
//Log base b of a = c is the same as ln(a)/ln(b) = c
//so b = exp(ln(a)/c)
 
    def numberOfWays(X:Int,N:Int):Int = {
       // Compute the answer in this function over here
       // It is fine to define new functions as and where required
       val rn: List[Int] = List.range(1, Math.sqrt(X).toInt + 1)
       def getRes(l: List[Int], acc: Int): Int = l match {
           case x :: xs =>
             if(Math.pow(x, N).toInt + acc > X) 0
             else if(Math.pow(x, N).toInt + acc == X) 1
             else getRes(xs, acc + Math.pow(x, N).toInt) + getRes(xs, acc)             
           case _ => 
             0
       }

       getRes(rn, 0)
    }

    def main(args: Array[String]) {
       println(numberOfWays(readInt(),readInt()))
    }
}
