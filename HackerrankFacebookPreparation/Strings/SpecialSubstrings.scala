object Solution {



import scala.collection.mutable.Set

    def checkBackwards(s: String, i: Int): Int = {
        var res = 0
        var curr = i

        while(curr >= 0 && s(i) == s(curr)){
            res += 1
            curr -= 1
        }

        res
    }

    def checkSurroundings(s: String, i: Int): Int = {
        var res = 0
        var curr = 1
        var char: Option[Char] = None

        while(i-curr >= 0 && i+curr < s.length && s(i-curr) == s(i+curr) && (char.isEmpty || s(i-curr) == char.get)){
            if(!char.isDefined){
                char = Some(s(i-curr))
            }
            res += 1
            curr+= 1
        }

        res
    }

    // Complete the substrCount function below.
    def substrCount(n: Int, s: String): Long = {
        if(s.length == 0) return 0
        var res = 0

        for(i <- 0 until s.length){
            
            val backwardsCount = checkBackwards(s, i)
            res += backwardsCount
            
            if(backwardsCount == 1){
                val surroundingsCount = checkSurroundings(s, i)
                res += surroundingsCount
            }
        }

        res
    }

