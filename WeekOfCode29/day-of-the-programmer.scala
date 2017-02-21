case class Range(start: Int, end: Int)

val julian: Range       = Range(1700, 1917)
val gregorian: Range    = Range(1919, 2700)
val yearToEvaluate: Int = scala.io.StdIn.readInt()

implicit class IntHelper(i: Int){
  def in(r: Range): Boolean = {
    if(i >= r.start && i <= r.end)
      true
    else false
  }
}

def getDateOfTheProgrammer(yearToEvaluate: Int): String = {

  (yearToEvaluate in julian, yearToEvaluate in gregorian) match {

    case (true, _) =>
      val leap: Boolean =
        if(yearToEvaluate % 4 == 0)
          true
        else false

      val day: String =
        if(leap) "12" else "13"

      day + ".09." + yearToEvaluate.toString
    case (_, true) =>
      val leap: Boolean =
        if((yearToEvaluate % 4 == 0 && yearToEvaluate % 100 != 0) ||
            yearToEvaluate % 400 == 0)
          true
        else false

      val day: String =
        if(leap) "12" else "13"

      day + ".09." + yearToEvaluate.toString

    case _         =>
      val day: String = "27"

      day + ".09." + yearToEvaluate.toString
  }

}

println(getDateOfTheProgrammer(yearToEvaluate))

