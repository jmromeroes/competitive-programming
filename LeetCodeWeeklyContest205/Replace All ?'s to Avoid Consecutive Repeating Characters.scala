import scala.collection.mutable.Set;
import scala.util.control.Breaks._;

object Solution {
    def modifyString(s: String): String = {
        if(s.length == 0) return s
        
        var charSet: Array[Char] = s.toCharArray
        
        for(i <- 0 until charSet.length){
            if(charSet(i) == '?'){
                breakable {
                    for(c <- 'a' to 'z'){
                        if(charSet.length == 1) {
                            return "a"
                        } else if(i == 0 && (charSet(1) == '?' || charSet(1) != c)){
                            charSet(i) = c
                            break;
                        } else if(i == charSet.length - 1 && (charSet(charSet.length - 2) != c)) {
                            charSet(i) = c
                            break;
                        } else if(i > 0 && i < charSet.length - 1 && (charSet(i + 1) == '?' || charSet(i+1) != c) && charSet(i-1) != c) {
                            charSet(i) = c
                            break;
                        }
                    }
                }
            }
        }
        
        charSet.toList.mkString("")
    }
}
