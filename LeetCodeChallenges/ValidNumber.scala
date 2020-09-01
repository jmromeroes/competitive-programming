object Solution {
    def isNumber(s: String, index: Int, isFloat: Boolean, hasExponent: Boolean): Boolean = {
        if(index >= s.length) true
        else s(index) match {
            case '.' =>
                if(s.length == 1 || hasExponent || isFloat || (index != 0 && (s(index-1) == 'e' || (index == s.length - 1 &&  !s(index-1).isDigit)))) false
                else isNumber(s, index+1, true, hasExponent)
            case '-' =>
                if((index != 0 && s(index - 1) != 'e') || s.length - 1 == index || s.length == 1) false
                else isNumber(s, index+1, isFloat, hasExponent)
            case '+' =>
                if((index != 0 && s(index - 1) != 'e') || s.length - 1 == index || s.length == 1) false
                else isNumber(s, index+1, isFloat, hasExponent)
            case 'e' =>
                if(hasExponent || index == 0 || (!s(index-1).isDigit && (s(index-1) != '.' || index == 1)) || s.length == index + 1) false
                else isNumber(s, index+1, isFloat, true)
            case x =>
                if(!s(index).isDigit) false
                else isNumber(s, index+1, isFloat, hasExponent)
        }
        
    }
    
    def isNumber(s: String): Boolean = {
        if(s.trim.length > 0) isNumber(s.trim, 0, false, false)
        else false
    }
    
}
