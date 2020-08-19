object Solution {
    def addBinary(a: String, b: String): String = {
        var _a = a
        var _b = b
        
        if(_a.length > _b.length){
            val zeros = Array.ofDim[Int](_a.length - _b.length).toList.map(_.toString).mkString("")
            _b = zeros + _b
        } else {
            val zeros = Array.ofDim[Int](_b.length - _a.length).toList.map(_.toString).mkString("")
            _a = zeros + _a
        }
        var res = ""
        var carry = '0'
        for(i <- _b.length - 1 to 0 by -1){
            val n1 = _b(i)
            val n2 = _a(i)
            
            if((n1 == '0' && n2 == '0')){
                res = carry + res
                carry = '0'
            } else if((n1 == '0' && n2 == '1') || (n1 == '1' && n2 == '0')) {
                if(carry == '0'){
                    carry = '0'
                    res = "1" + res
                } else {
                    carry = '1'
                    res = "0" + res
                    if(i == 0){
                        res = "1" + res
                    }
                }
            } else {
                if(carry == '0'){
                    carry = '1'
                    res = "0" + res
                    if(i == 0){
                        res = "1" + res
                    }
                } else {
                    res = "1" + res
                    if(i == 0){
                        res = "1" + res
                    }
                }
            }
        }
        
        res
    }
}
