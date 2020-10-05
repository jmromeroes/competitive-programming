import scala.collection.JavaConverters._
import scala.collection.mutable.Map
// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object Solution {
    
  def getGroup(taskName: String, s: String): String = {
    var index = taskName.length
    var group = ""
    
    
    while(index < s.length && s(index).isDigit){
        
        
        group += s(index).toString
        index += 1
    }
    
    return group
  }
  
  def getTaskName(s: String): String = {
    var index: Int = 0
    var res = ""
    var c = s(index)
    
    while(!c.isDigit){
        res += c.toString
        index += 1
        c = s(index)
    }
    
    return res
  }
  
  def solution(t: Array[String], r: Array[String]): Int = {
    
    val m: Map[String, List[String]] = Map()
    
    val taskName = getTaskName(t(0))
    for(i <- 0 until t.length){
        val group = getGroup(taskName, t(i))
        m.get(group) match {
            case None =>
                m(group) = List(r(i))
            case Some(v) =>
                m(group) = r(i)::v
        }
    }
    
    var currGroup: Int = 1
    var maxGroups = 0
    var successfulGroups = 0

    while(m.contains(currGroup.toString)){
        if(!m(currGroup.toString).exists(_ != "OK")){
            successfulGroups += 1
        }
        
        maxGroups += 1
        currGroup += 1
    }
    
    return Math.floor((successfulGroups*100)/maxGroups).toInt
  }
}
