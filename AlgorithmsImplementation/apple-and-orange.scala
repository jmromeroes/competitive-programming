 val sc = new java.util.Scanner (System.in)
 var s = sc.nextInt()
 var t = sc.nextInt()
 var a = sc.nextInt()
 var b = sc.nextInt()
 var m = sc.nextInt()
 var n = sc.nextInt()
 
 var applesInHouse: Int = 0
 for(apple_i <- 0 to m-1) {
   val ap: Int = sc.nextInt()
   if(a + ap >= s && a + ap <= t)
       applesInHouse += 1
 }
         
 println(applesInHouse)
 var orangesInHouse: Int = 0
 for(orange_i <- 0 to n-1) {
   val or: Int = sc.nextInt()
     if(b + or >= s && b + or <= t)
       orangesInHouse += 1
 }
 println(orangesInHouse)
