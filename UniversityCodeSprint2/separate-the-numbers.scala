import scala.util.control.Breaks._

val numberOfCases: Int = scala.io.StdIn.readInt()

def getBeautifulNumber(input: String): (Boolean, BigInt) = {

  var sl: String = ""

  for(n <- 1 to input.size/2) {
    if(input(0) != '0' && isBeautifulNumber(input.slice(0, n), input.slice(n, input.size))) {
      return (true, BigInt(input.slice(0,n)))
    }
  }

  (false, 0)
}

def isBeautifulNumber(previousNumber: String, rest: String): Boolean = {
  val pv: BigInt = BigInt(previousNumber)

  if(rest.size == 0)
    return true

  if(rest(0) == '0')
    return false

  var numberFound = false
  var index = -1

  breakable {
    for(i <- 1 until rest.size + 1){
      if(BigInt(rest.slice(0,i)) - pv == BigInt("1")) {
        index = i
        numberFound = true
        break
      } 
    }
  }

  if(numberFound){
    return isBeautifulNumber(rest.slice(0,index), rest.slice(index, rest.size))
  }else
    return false    
  
}

for(_ <- 0 until numberOfCases) {
  getBeautifulNumber(scala.io.StdIn.readLine()) match {
    case (true, number) =>
      println(s"YES $number")
    case (false, number) =>
      println("NO")
  }
}
