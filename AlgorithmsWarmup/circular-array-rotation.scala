val sc = new java.util.Scanner (System.in)
var n: Int = sc.nextInt
var k: Int = sc.nextInt
var q: Int = sc.nextInt

val array: Array[Int] = new Array[Int](n)
var index: Int = 0

def decreaseIndex(index: Int): Int =
  if(index == 0) n - 1
  else index - 1

def increaseIndex(index: Int): Int =
  if(index == n - 1) 0
  else index + 1

for(i <- 0 until n)
  array(i) = sc.nextInt

for(i <- 0 until k)
  index = decreaseIndex(index)

for(i <- 0 until q) {
  val m: Int = sc.nextInt
  var x: Int = index

  for(j <- 0 until m)
    x = increaseIndex(x)

  println(array(x))
}

