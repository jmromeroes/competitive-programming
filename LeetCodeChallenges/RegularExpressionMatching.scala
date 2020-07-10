import scala.collection.mutable._

object Solution {
    def lookForCharacter(s: String, stringPointer: Int, c: Char): ListBuffer[Int] = {
        val l: ListBuffer[Int] = new ListBuffer()
        
        for(i <- stringPointer until s.length){
            if(s(i) == c || c == '.'){
                l += i
            }
        }
        
        return l
    }
    
    def checkIfRestIsOptional(p: String, patternPointer: Int): Boolean = {
        for(i <- patternPointer until p.length){
            if(p(i) != '*'){
                if(i == p.length - 1 || p(i + 1) != '*')
                    return false
            }
        }
        true
    }
    
    def isMatchRecursion(s: String, stringPointer: Int, p: String, patternPointer: Int): Boolean = {
        if(stringPointer >= s.length && (patternPointer >= p.length)){
            return true
        } else if(stringPointer >= s.length && p.length < patternPointer+3) {
            if(p.length == patternPointer+1 && p(patternPointer) == '*')
                return true
            else if(p.length == patternPointer+2 && p(patternPointer+1) == '*')
                return true
            else 
                return false
            
        } else if(stringPointer >= s.length && p.length > patternPointer+2 && p(patternPointer+1) == '*') {
            return isMatchRecursion(s, stringPointer, p, patternPointer+2)
        } else if(patternPointer >= p.length || stringPointer >= s.length){
            return false
        }
        
        p(patternPointer) match {
            case '*' =>
                val prevChar: Char = p(patternPointer-1)
                if(prevChar == '.'){
                    if(patternPointer == p.length - 1){
                        return true
                    } else {
                        
                        if(checkIfRestIsOptional(p, patternPointer+1)){
                            return true
                        }
                        
                        var nextIndex: Int = patternPointer + 1
                        var isNextOptional: Boolean = if(patternPointer + 2 < p.length) p(patternPointer+2) == '*' else false
                        
                        while(isNextOptional){
                          nextIndex = nextIndex + 2
                          isNextOptional = if(nextIndex + 1 < p.length) p(nextIndex+1) == '*' else false
                        }
                        
                        val nextChars: ListBuffer[Int] = lookForCharacter(s, stringPointer, p(nextIndex))
                        if(nextChars.length == 0){
                            return isMatchRecursion(s, stringPointer, p, patternPointer+1)
                        } else {
                            for(nextChar <- nextChars){
                                if(isMatchRecursion(s, nextChar, p, patternPointer+1)){
                                    return true
                                }
                            }
                            
                            return isMatchRecursion(s, stringPointer, p, patternPointer+1) || checkIfRestIsOptional(p, patternPointer+1)
                        }
                    }
                } else {
                    if(s(stringPointer) == prevChar){
                        return isMatchRecursion(s, stringPointer+1, p, patternPointer) ||
                               isMatchRecursion(s, stringPointer+1, p, patternPointer+1) ||
                               isMatchRecursion(s, stringPointer, p, patternPointer+1)
                    } else {
                        return isMatchRecursion(s, stringPointer, p, patternPointer+1)
                    }
                }
            case '.' =>
                if(patternPointer+1 < p.length && p(patternPointer+1) == '*')
                    return isMatchRecursion(s, stringPointer+1, p, patternPointer+1) ||
                           isMatchRecursion(s, stringPointer, p, patternPointer+2)
                else
                    return isMatchRecursion(s, stringPointer+1, p, patternPointer+1)
            case c =>
                if(s(stringPointer) == c){
                    if(patternPointer+1 < p.length && p(patternPointer+1) == '*')
                        return isMatchRecursion(s, stringPointer+1, p, patternPointer+2) ||
                               isMatchRecursion(s, stringPointer, p, patternPointer+2) ||
                               isMatchRecursion(s, stringPointer+1, p, patternPointer+1)
                    else
                        return isMatchRecursion(s, stringPointer+1, p, patternPointer+1)
                    
                } else if(patternPointer+1 < p.length && p(patternPointer+1) == '*') {
                    return isMatchRecursion(s, stringPointer, p, patternPointer+2)  
                } else {
                    return false
                }
        }
        
        false
    }
    
    def isMatch(s: String, p: String): Boolean = {
        isMatchRecursion(s, 0, p, 0)
    }
    
}