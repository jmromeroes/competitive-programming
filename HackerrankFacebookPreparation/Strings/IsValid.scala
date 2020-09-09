// Complete the isValid function below.
    def isValid(s: String): String = {
        val ref: Array[Int] = Array.ofDim[Int](28)

        for(c <- s){
            ref(c - 'a') += 1
        }
        
        var numberOfExceeds = 0
        var globalNumber = 0

        for(i <- 0 until ref.length){
            if(ref(i) != 0){
                if(globalNumber == 0){
                    globalNumber = ref(i)
                } else if(Math.abs(globalNumber - ref(i)) > 1 && ref(i) > 1){
                    return "NO"
                } else if(Math.abs(globalNumber - ref(i)) == 1 || ref(i) == 1){
                    numberOfExceeds += 1

                    if(numberOfExceeds > 1) return "NO"
                }
            }
        } 

        
        "YES"   
    }
