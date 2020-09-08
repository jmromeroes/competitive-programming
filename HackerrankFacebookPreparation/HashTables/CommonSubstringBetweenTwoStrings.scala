def twoStrings(s1: String, s2: String): String = {
        val s: Set[Char] = Set()
        for(c <- s1){
            s.add(c)
        }

        for(c <- s2){
            if(s.contains(c)) return "YES"
        }

        "NO"
    }
