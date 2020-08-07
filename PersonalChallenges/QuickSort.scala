object QuickSort {

  def sort(a: Array[Int], start: Int, end: Int): Unit = {
    if(start == end || start >= a.length || end < 0) return
    
    val pivot: Int = a(end)
    var _start = start
    var _end = end - 1

    while(_start < _end){
      if(a(_start) <= pivot) _start += 1
      else {
        while(_end > _start && a(_end) > pivot) _end -= 1
        val temp = a(_start)
        a(_start) = a(_end)
        a(_end) = temp
        _start += 1
      }
    }

    if(a(end) < a(_end)){
      val temp = a(end)
      a(end) = a(_end)
      a(_end) = temp
    }
    sort(a, start, _end)
    sort(a, _end+1, end)
  }

  def sort(a: Array[Int]): Array[Int] = {
    sort(a, 0, a.length-1)
    println(a.toList.mkString(" -> "))
    a
  }

}

QuickSort.sort(Array(9,8,7,6,5,4,3,2,1))
QuickSort.sort(Array(1, -3, -2, 1000, -1000))
QuickSort.sort(Array(1, 2, 3, 4, 5, 6, 7))
