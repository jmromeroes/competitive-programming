val hourInput = scala.io.StdIn.readLine
val hour = hourInput.take(2)
val mins = hourInput.drop(3).take(2)
val seconds = hourInput.drop(6).take(2)
val AMorPM = hourInput.drop(8).take(2)

val outputHour: String = AMorPM match {
  case "AM" =>
    if(hour == "12") "00"
    else hour
  case "PM" =>
    if(hour == "12") "12"
    else (hour.toInt + 12).toString
}

println(s"$outputHour:$mins:$seconds")
