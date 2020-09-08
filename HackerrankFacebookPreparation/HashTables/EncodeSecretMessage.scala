import scala.collection.mutable.Map
    def checkMagazine(magazine: Array[String], note: Array[String]) {
        val map: Map[String, Int] = Map()
        for(m <- magazine){
            map.get(m) match {
             case None => map(m) = 1
             case Some(count) => map(m) = count + 1
            }
        }
        
        
        for(word <- note) {
            map.get(word) match {
             case None => 
                return print("No") 
             case Some(count) => 
                map(word) -= 1
                if(map(word) < 0) return print("No")
            }
        }

        print("Yes")
    }
