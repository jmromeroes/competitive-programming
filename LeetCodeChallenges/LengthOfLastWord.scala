object Solution {
    def lengthOfLastWord(s: String): Int = {
        if(s.length == 0 || s.trim().length == 0) return 0
        val l = s.split(" ")
        l(l.length-1).length
    }
}
