object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var s = sc.next();
    val res =
      s.foldLeft(0){
        (x,y) => if(y == Character.toUpperCase(y)) x + 1 else x
      } + 1
       
    print(res)
  }

}
