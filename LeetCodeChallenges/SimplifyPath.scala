import scala.collection.mutable.Stack

object Solution {
    def simplifyPath(path: String): String = {
        val splitted = path.split("/")
        val stack: Stack[String] = Stack()
        
        for(word <- splitted){
            word match {
                case "." => ()
                case ".." =>
                    if(stack.nonEmpty) stack.pop()
                case "" => ()
                case x =>
                    stack.push(word)
            }
        }
        
        val stack2: Stack[String] = Stack()
        if(stack.isEmpty) "/"
        else {
            while(!stack.isEmpty){
                stack2.push(stack.pop())
            }
            var res = ""
            while(!stack2.isEmpty){
                res += s"/${stack2.pop()}"
            }
            res
        }
    }
}
