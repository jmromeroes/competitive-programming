object Solution {
    def sortColors(nums: Array[Int]): Unit = {
        var ptr1 = -1
        var ptr2 = -1
        
        for(index <- 0 until nums.length){
            
            
            nums(index) match {
                case 0 =>
                    if(ptr1 != -1 && ptr2 != -1){
                        nums(ptr2) = 1
                        nums(ptr1) = 0
                        nums(index) = 2
                        
                        ptr1 += 1
                        ptr2 += 1
                    } else if(ptr1 == -1 && ptr2 != -1){
                        nums(ptr2) = 0
                        nums(index) = 2
                        
                        ptr2 += 1
                    } else if(ptr1 != -1){
                        nums(ptr1) = 0
                        nums(index) = 1
                        
                        ptr1 += 1
                    }
                case 1 =>
                    if(ptr2 != -1){
                        nums(ptr2) = 1
                        
                        if(ptr1 == -1){
                            ptr1 = ptr2
                        }
                        
                        nums(index) = 2
                        ptr2 += 1
                    } else {
                        if(ptr1 == -1){
                            ptr1 = index
                        }
                    }
                case _ => 
                    if(ptr2 == -1){
                        ptr2 = index
                    }
            }
        }
    }
}
