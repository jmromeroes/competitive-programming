object Solution {

  def main(args: Array[String]) {

    val n = scala.io.StdIn.readInt()
    1 to n foreach { _ => 
      val grade: Int = scala.io.StdIn.readInt()
      val rounded: Int = (grade/5 + 1) * 5
      if(rounded - grade < 3 && grade >= 38)
        println(rounded)
      else println(grade)
    }

  }

}
