import scala.collection.mutable._
import scala.annotation.tailrec
import scala.util.control.Breaks._

case class TrieTree(c: Option[Char], children: Map[Char, TrieTree])

object Solution {
    type Word = String
    
    def createWordTree(word: Word, tree: TrieTree): TrieTree = {
        var tempTree = tree
        
        for(i <- 0 until word.length){
               tempTree.children.get(word(i)) match {
                   case None => 
                        tempTree.children(word(i)) = TrieTree(Some(word(i)), Map())
                        tempTree = tempTree.children(word(i))
                   case Some(_tree) => 
                        tempTree = _tree
               }
        }
        
        tree
    }
    
    def checkIfWordInTree(word: Word, start: Int, end: Int, tree: TrieTree): Boolean = {
        if(start >= word.length || end > word.length) return false
        
        var tempTree = tree
        
        for(i <- start until end){
               tempTree.children.get(word(i)) match {
                   case None => return false
                   case Some(_tree) =>
                        tempTree = _tree
               }
        }
        
        true
    }
    
    
    def findSubstring(s: String, words: Array[String]): List[Int] = {
        if(words.length == 0) return List()
        
        val windowSize: Int = words(0).length
        var tree: TrieTree = TrieTree(None, Map())
        var referenceMap: Map[Int, Option[Word]] = Map()
        var countMap: Map[Word, Int] = Map()
        var res: ListBuffer[Int] = ListBuffer()
        
        /**
        Creation of trie tree for words
        **/
        for(word <- words){
            val firstLetter = word(0)
            
            tree = createWordTree(word, tree)
            
            countMap.get(word) match {
                case None =>
                    countMap(word) = 1
                case Some(count) =>
                    countMap(word) = count + 1
            }
        }
        
        val wordSet = words.toSet
        
        /**
        Check for words
        **/
        for(i <- 0 until s.length - (words.length*windowSize)+1){
            val newMap: Map[Word, Int] = Map()
            
            var breakLoop = false
            var j = i
            var numberOfWords = 0
            var isValid = true
            
            while(!breakLoop){
                referenceMap.get(j) match {
                    case None =>
                        
                        if(checkIfWordInTree(s, j, j+windowSize, tree)){
                            val foundWord = s.substring(j, j+windowSize)
                            
                            newMap(foundWord) = newMap.getOrElse(foundWord, 0) + 1
                            referenceMap(j) = Some(foundWord)
                            
                            if(newMap(foundWord) == countMap(foundWord)){
                                numberOfWords += 1
                                if(numberOfWords == wordSet.size) breakLoop = true
                            } else if(newMap(foundWord) > countMap(foundWord)) {
                                isValid = false
                                breakLoop = true
                            }
                        } else {
                            referenceMap(j) = None
                            isValid = false
                            breakLoop = true
                        }
                    case Some(wordStatus) =>
                        wordStatus match {
                            case None => 
                                breakLoop = true
                                isValid = false
                            case Some(word) => 
                                newMap(word) = newMap.getOrElse(word, 0) + 1
                                                                
                                if(newMap(word) == countMap(word)){
                                    numberOfWords += 1
                                    if(numberOfWords == wordSet.size) breakLoop = true
                                } else if(newMap(word) > countMap(word)) {
                                    isValid = false
                                    breakLoop = true
                                }
                        }
                }
                
                j += windowSize
            }
            
            if(isValid) res += i
        }
        
        res.toList
    }
}