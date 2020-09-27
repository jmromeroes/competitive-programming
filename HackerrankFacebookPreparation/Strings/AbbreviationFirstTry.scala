def abbreviation(a: String, b: String): String = {
        val dp: Map[String, String] = Map()

        def abbreviation(a: String, indexA: Int, b: String, indexB: Int): String = {
            dp.get(s"${indexA}-${indexB}") match {
                case Some(v) => v
                case None =>
                    if(indexA < a.length){
                        if(indexB < b.length){
                            if(a(indexA).isUpper){
                                if(a(indexA) != b(indexB)){ 
                                    dp(s"${indexA}-${indexB}") = "NO"
                                    return "NO"
                                } else abbreviation(a, indexA + 1, b, indexB + 1)
                            } else{
                                if(a(indexA) == b(indexB).toLower)
                                    if(abbreviation(a, indexA + 1, b, indexB + 1) == "YES" || abbreviation(a, indexA + 1, b, indexB) == "YES"){
                                        dp(s"${indexA}-${indexB}") = "YES"
                                        return "YES"
                                    } else{
                                        abbreviation(a, indexA + 1, b, indexB)
                                    }
                                else abbreviation(a, indexA + 1, b, indexB)
                            }
                        } else{
                            if(a(indexA).isUpper) {
                                dp(s"${indexA}-${indexB}") = "NO"
                                return "NO"
                            } else{
                                return abbreviation(a, indexA + 1, b, indexB)
                            }
                        }
                    } else {
                        if(indexB < b.length) return "NO"
                        else return "YES"
                    }
            }
        }    
        
        val res = abbreviation(a, 0 , b, 0)
        return res
}
