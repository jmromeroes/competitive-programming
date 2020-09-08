def alternatingCharacters(s: String): Int = {
    if(s.length <= 1) return 0
    var res = 0
    var char: Char = s(0)
    for(i <- 1 until s.length){
        if(s(i) == char) res += 1
        else char = s(i)
    }
    res
}
