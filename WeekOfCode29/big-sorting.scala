for { l <- { for(n <- 0 until scala.io.StdIn.readInt()) yield BigInt(scala.io.StdIn.readLine()) }.sorted } { println(l) }
