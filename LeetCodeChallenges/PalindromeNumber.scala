object Solution {
    def isPalindrome(x: Int): Boolean = {
        if(x < 10 && x >= 0) return true
        if(x < 0 || x % 10 == 0) return false
        
        var temp = x
        var res = 0
        while(temp != 0){
            val m = temp % 10
            
            res = res*10 + m
            temp = (temp - m) / 10
        }
        
        print(res, x)
        return res == x
    }
}