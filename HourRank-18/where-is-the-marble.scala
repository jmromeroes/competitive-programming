object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    var m = sc.nextInt()
    var n = sc.nextInt()
    int a0 = 0
    while(a0 < n){
      var a = sc.nextInt()
      var b = sc.nextInt()
      // your code goes here
      if(a == m)
        m = b
      else if(b == m)
        m = a

      a0+=1
    }
  }

}
