import scala.collection.mutable.ListBuffer

object Solution {
    
    def getMaxWordsIndex(words: Array[String], maxWidth: Int, currWord: Int): Int = {
        var _currWidth = 0
        var curr = currWord
        while(_currWidth < maxWidth && curr < words.length){
            _currWidth += words(curr).length

            if(_currWidth > maxWidth)
                return curr - 1
            else if(_currWidth == maxWidth) return curr
            
            curr += 1
            _currWidth += 1
        }
        
        curr - 1
    }
    
    def packWords(words: Array[String], start: Int, end: Int): List[String] =
        (start to end).toList.map(index => words(index))
    
    def getCharsInList(words: List[String]): Int = 
        words.foldLeft(0)((acc: Int, word: String) => acc + word.length)
    
    def fromIntToEmptyString(size: Int): String = {
        var res = ""
        
        for(i <- 0 until size){
            res += " "
        }
        
        res
    }
    
    def fromListToString(words: List[String], maxWidth: Int, oneSpace: Boolean = false): String = {
        val wordsLength = getCharsInList(words)
        var freeSpaces: Float = maxWidth - wordsLength
        
        var res = ""
        
        if(!oneSpace){
            for(i <- 0 until words.length){
                val spaceSize = if(words.length > 1)
                    Math.ceil(freeSpaces/(words.length - i - 1)).toInt                    
                else freeSpaces
                
                res += words(i) + fromIntToEmptyString(Math.min(freeSpaces, spaceSize).toInt)
                freeSpaces -= spaceSize
            }
        } else {
            for(word <- words){
                res += word + (if(freeSpaces > 0) " " else "")
                freeSpaces -= 1
            }
            
            res = res + fromIntToEmptyString(freeSpaces.toInt)
        }
        res
    } 
    
    def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
        
        var curr = 0
        val fullWordsResult: ListBuffer[List[String]] = ListBuffer()
        
        while(curr < words.length){
            val res = getMaxWordsIndex(words, maxWidth, curr)
            fullWordsResult += packWords(words, curr, res)
            curr = res+1
        }
        
        {for {
            res <- 0 until fullWordsResult.length - 1
        } yield {
            fromListToString(fullWordsResult(res), maxWidth)
        }}.toList ++ List((fromListToString(fullWordsResult(fullWordsResult.length - 1), maxWidth, true)))
        
        
    }
}
