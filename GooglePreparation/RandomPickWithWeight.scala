class Solution(_w: Array[Int]) {
    var currIndex: Int = 0
    var currTimes: Int = _w(0)
    
    def pickIndex(): Int = {
        val res = _w(currIndex)
        currTimes -= 1
        
        if(currTimes == 0) {
            currIndex += 1
            if(currIndex == _w.length){
                currIndex = 0
            }
            currTimes = _w(currIndex)
        }
        
        return currIndex
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(w)
 * var param_1 = obj.pickIndex()
 */