val sc = new java.util.Scanner (System.in)
val x1 = sc.nextInt()
val v1 = sc.nextInt()
val x2 = sc.nextInt()
val v2 = sc.nextInt()

/*
 YES if there exists a 't' such that: 
   x1 + t*v1 == x2 + t*v2 => (x2 - x1) == t(v1 - v2) 
 Then if (v1 - v2) is multiple of (x2 - x1) it's "YES"
 else it's "NO"
 */
if(v2 >= v1)
    println("NO")
else if(((x2 - x1) % (v1 - v2) != 0))
    println("NO")
else
    println("YES")
