def makeAnagram(a: String, b: String): Int = {
        val ref: Array[Int] = Array.ofDim[Int](28)

        for(c <- a){
            ref(c - 'a') += 1
        }

        for(c <- b){
            ref(c - 'a') -= 1
        }

        ref.toList.foldRight(0)((curr, acc) => acc + Math.abs(curr))
    }
