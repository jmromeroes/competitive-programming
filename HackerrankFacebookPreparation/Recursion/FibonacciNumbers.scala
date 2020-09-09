import scala.io.StdIn._;

     def fibonacci(x:Int):Int = {
		if(x <= 1) x
        else fibonacci(x - 1) + fibonacci(x - 2)
    }
