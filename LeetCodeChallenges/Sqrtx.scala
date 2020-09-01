object Solution {
    def mySqrt(x: Int): Int = {
        if(x == 0) return x
        var start = 1
        var end = x
        var _x = (start + end)/2
        
        while(start < end-1){
            if(_x == x/_x){
                return _x
            } else if(_x < x/_x) {
                start = _x
            } else {
                end = _x
            }
            
            _x = (start + end)/2
        }
        
        _x
    }
}
