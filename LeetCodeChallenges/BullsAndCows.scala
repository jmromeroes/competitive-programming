import scala.collection.mutable._

object Solution {
    def getHint(secret: String, guess: String): String = {
        val map: Map[Char, Int] = Map() // Here we store the count of chars that we find in the guess string
        
        var bulls = 0
        var cows = 0
        
        /*  
            First we store the chars with their respective ocurrences
        */
        for(i <- 0 until secret.length){
            map.get(secret(i)) match {
                case None =>
                    map(secret(i)) = 1
                case Some(v) =>
                    map(secret(i)) += 1
            }
        }
        
        /*  
            Here we look for bulls which is fairly simple
        */
        for(i <- 0 until guess.length){
            if(secret(i) == guess(i)){
                bulls += 1
                map(secret(i)) -= 1
            }
        }
        
        /*  
            Here we look for cows by going into the map and looking that there are enough characters stored there that are not bulls
        */
        for(i <- 0 until guess.length){
            map.get(guess(i)) match { // This is just like 'Look for this character in the map'
                case None => ()  // If the character is not in the map
                case Some(v) => { //If the character is in the map
                    if(guess(i) != secret(i)){ //Here we verify we did not count it already as a bool
                        map(guess(i)) = v - 1 // We reduce the number of available chars
                        if(map(guess(i)) >= 0){ //If the number of chars is greater or equals than 0 and this character is not a bull, it means it's a cow because it's present in both strings
                            cows += 1
                        }
                    }
                }
            }
        }
        
        s"${bulls}A${cows}B" //Just return the required format
    }
}
