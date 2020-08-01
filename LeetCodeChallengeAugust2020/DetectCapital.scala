object Solution {
    def detectCapitalUse(word: String): Boolean = {
       if(word.length == 1) return true
       
       var firstCharUpper = word(0).isUpper
       var secondCharUpper = word(1).isUpper
        
       var charCase: Int = (firstCharUpper, secondCharUpper) match {
           case (true, true) => 1
           case (true, false) => 2
           case (false, false) => 3
           case _ => 4
       }
        
       if(charCase == 4) return false
        
       for(i <- 2 until word.length){
          val isValid = charCase match {
             case 1 =>
                if(!word(i).isUpper) false else true
             case 2 =>
                if(word(i).isUpper) false else true
             case 3 =>
                if(word(i).isUpper) false else true
          }
          
          if(!isValid) return false
       }
       true
    }
}