def hourglassSum(arr: Array[Array[Int]]): Int = {
        var res = Int.MinValue

        for(y <- 0 until arr.length - 2){
            for(x <- 0 until arr.length - 2){
                var sum = 0
                sum += arr(y)(x)
                sum += arr(y+1)(x+1)
                sum += arr(y)(x+1)
                sum += arr(y)(x+2)
                sum += arr(y+2)(x)
                sum += arr(y+2)(x+1)
                sum += arr(y+2)(x+2)

                res = Math.max(sum, res)
            }
        }

        res
    }
