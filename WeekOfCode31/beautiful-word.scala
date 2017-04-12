object Solution {

    def main(args: Array[String]) {
        import scala.util.control.Breaks._
        import scala.collection.immutable.HashSet
          
        val sc = new java.util.Scanner (System.in)
        val w: String = sc.next
        val hs: HashSet[Char] = HashSet('a','e','i','o','u','y')
          
        var beautiful: Boolean = true
        // Print 'Yes' if the word is beautiful or 'No' if it is not.
        breakable{
          for(i <- 1 until w.size){
            if(w(i) == w(i - 1) || ((hs contains w(i)) && (hs contains w(i - 1)))){
              beautiful = false
              break
            }
          }
        }
      
        println(if(beautiful) "Yes" else "No")
      
    }

}
