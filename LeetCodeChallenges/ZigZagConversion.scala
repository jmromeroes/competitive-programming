import scala.collection.mutable._

object Solution {
    
    def convert(s: String, numRows: Int): String = {
        if(numRows == 1)
            return s
        
        val map: Map[Int, List[Char]] = Map()
        
        var level: Int = 1
        var goingDown = true
        
        var res = ""
        
        for(c <- s){
            map.get(level) match {
                case None => 
                    map(level) = List()
                    ()
                case Some(_) => ()
            }
            
            map(level) = map(level) ++ List(c)
            if(goingDown) {
                if(level == numRows){
                    goingDown = false
                    level -= 1
                } else {
                    level += 1
                }
            } else {                
                if(level == 1){
                    goingDown = true
                    level += 1
                } else {
                    level -= 1
                }
            }
        }
        
        for(i <- 1 to numRows){
            map.get(i) match {
                case None => ()
                case Some(l) => 
                    for(c <- l){
                        res += c.toString
                    }
            }
        }
        

        return res
    }
}