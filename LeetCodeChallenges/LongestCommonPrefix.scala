object Solution {
    def longestCommonPrefix(strs: Array[String]): String = {
        if(strs.isEmpty) return ""
        var res: String = "";
        for(i <- 0 until strs.map(s => s.length).min){
            var l: Option[Char] = None
            for(s <- strs){
                l match {
                    case None => 
                        l = Some(s(i))
                    case Some(v) =>
                        if(s(i) != v) return res
                }
            }
            res = res + l.get
        }
        res
    }
}