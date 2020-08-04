object MergeSort {

  def merge(a: Array[Int], start: Int, end: Int): Unit = {
    var middle: Int = if((end - start + 1) % 2 == 0) Math.floor((end + start) / 2).toInt else ((end + start)/2).toInt

    if(start == end){
      return
    } else if(end - start == 1){
      if(a(end) <= a(start)){
        val temp = a(end)
        a(end) = a(start)
        a(start) = temp
      }

      return
    } else {
      var start1: Int = start
      var start2: Int = middle + 1

      while(start1 <= middle && start2 <= end){
        if(a(start1) <= a(start2)){
          start1 += 1
        } else {
          val temp = a(start2)
          for(i <- start2 until start1 by -1){
            a(i) = a(i-1)
          }
          a(start1) = temp
          start1 += 1
          start2 += 1
          middle += 1
        }
      }
    }

  }

  def sort(a: Array[Int], start: Int, end: Int): Unit = {
    val middle: Int = if((end - start + 1) % 2 == 0) Math.floor((end + start) / 2).toInt else ((end + start)/2).toInt

    if(end == start) return
    else {
      sort(a, start, middle)
      sort(a, middle + 1, end)
      merge(a, start, end)
    }
  }

  def sort(a: Array[Int]): Array[Int] = {
    sort(a, 0, a.length-1)
    println(a.toList.mkString(","))
    a
  }

}

MergeSort.sort(Array(9,8,7,6,5,4,3,2,1,0))
MergeSort.sort(Array(100,8,7,4 ,4,3,-3,1,0))
