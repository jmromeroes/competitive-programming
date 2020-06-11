class MovingAverage(_size: Int) {

    val referenceArray: Array[Int] = new Array[Int](_size)
    var currentIndex: Int = 0
    
    def next(`val`: Int): Double = {
        if(currentIndex < _size){
            referenceArray(currentIndex) = `val`
            currentIndex = currentIndex + 1
            return referenceArray.foldLeft(0)((x,y) => x+y).toDouble / currentIndex
        } else {
            referenceArray(currentIndex % _size) = `val`
            currentIndex = currentIndex + 1
            return referenceArray.foldLeft(0)((x,y) => x+y).toDouble / _size
        }
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = new MovingAverage(size)
 * var param_1 = obj.next(`val`)
 */
