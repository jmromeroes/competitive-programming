object Solution {
    def expressiveWords(input: String, word: String): Boolean = {
        var pointerInput: Int = 0
        var pointerWord: Int = 0
        var currentGroupSize: Int = 0

        while(pointerInput < input.length){
            if(input(pointerInput) != word(pointerWord)){
                return false
            } else if(pointerInput == input.length - 1 && pointerWord == word.length - 1 && input(pointerInput) == word(pointerWord)){
                return true
            } else if(pointerInput < input.length - 1 && pointerWord < word.length - 1) {             
                
                 if(input(pointerInput+1) == word(pointerWord+1)){
                     
                     if(input(pointerInput+1) == input(pointerInput)){
                         currentGroupSize += 1
                     } else {
                         currentGroupSize = 0
                     }
                     pointerInput += 1
                     pointerWord += 1
                 } else if(input(pointerInput+1) == input(pointerInput)){
                     val c: Char = input(pointerInput)
                     pointerWord += 1
                     
                     while(input(pointerInput) == c){
                         currentGroupSize += 1
                         pointerInput += 1
                     }
                     
                     if(currentGroupSize < 3){
                         return false
                     }
                     currentGroupSize = 0
                 } else {
                     return false
                 }
            } else if(pointerInput < input.length - 1){
                val c: Char = input(pointerInput)

                while(pointerInput < input.length && input(pointerInput) == c){
                    pointerInput += 1
                    currentGroupSize += 1
                }
                
                if(currentGroupSize < 3){
                    return false
                }
                currentGroupSize = 0
                
                if(pointerInput == input.length){
                    return true
                } else {
                    return false
                }
                
            } else {
                return false
            }
        }
        
        return if(pointerWord != word.length || pointerInput != input.length) false else true
    }
    
    def expressiveWords(S: String, words: Array[String]): Int = {
        return words.filter(word => expressiveWords(S, word)).length
    }
}