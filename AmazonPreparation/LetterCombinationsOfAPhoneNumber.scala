import scala.collection.mutable._

object Solution {
    
    val referenceMap: Map[Char, ListBuffer[String]] = Map(
        '2' -> ListBuffer("a","b","c"),
        '3' -> ListBuffer("d","e","f"),
        '4' -> ListBuffer("g","h","i"),
        '5' -> ListBuffer("j","k","l"),
        '6' -> ListBuffer("m","n","o"),
        '7' -> ListBuffer("p","q","r", "s"),
        '8' -> ListBuffer("t","u","v"),
        '9' -> ListBuffer("w","x","y", "z")
    )
    
    def letterCombinations(digits: String, currentIndex: Int): ListBuffer[String] = {
        if(currentIndex == digits.length - 1){
            return referenceMap(digits(currentIndex))
        }
        
        val digitCombinations: ListBuffer[String] = ListBuffer()
        for(digit <- referenceMap(digits(currentIndex))){
            for(nextCombination <- letterCombinations(digits, currentIndex+1)){
                digitCombinations += (digit + nextCombination)
            }
        }
        
        return digitCombinations
    }
    
    def letterCombinations(digits: String): List[String] = {
        if(digits.length == 0){
            return List()
        }

        letterCombinations(digits, 0).toList
    }
}