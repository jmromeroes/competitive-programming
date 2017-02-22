//for { l <- { for(n <- 0 until scala.io.StdIn.readInt()) yield BigInt(scala.io.StdIn.readLine()) }.sorted } { println(l) }
case class Node(value: BigInt, var left: Option[Node] = None, var right: Option[Node] = None)

case class Tree(root: Node) {

  def addNode(nodeToAdd: Node, nodeInTree: Node): Unit = {
    if(nodeToAdd.value < nodeInTree.value) {

      nodeInTree.left match {
        case None =>
          nodeInTree.left = Some(nodeToAdd)
        case Some(node) =>
          addNode(nodeToAdd, node) 
      }
    } else {
      nodeInTree.right match {
        case None =>
          nodeInTree.right = Some(nodeToAdd)
        case Some(node) =>
          addNode(nodeToAdd, node) 
      }
    }
  } 

  def printTree(node: Option[Node]): Unit = {

    node match {
      case None => ()
      case Some(node) =>

        node.left match {
          case None       => ()
          case Some(node) => printTree(Some(node))
        }
        
        println(node.value)
        
        node.right match {
          case None       => ()
          case Some(node) => printTree(Some(node))
        }
    }
  }
  
  def addNode(nodeToAdd: Node): Unit =
    addNode(nodeToAdd, root)

  def printTree(): Unit =
    printTree(Some(root))

}

val numberOfBigs: Int = scala.io.StdIn.readInt()
val root: Node = Node(BigInt(scala.io.StdIn.readLine()))
val tree: Tree = Tree(root) 

for(n <- 0 until (numberOfBigs - 1)) {
  tree.addNode(Node(BigInt(scala.io.StdIn.readLine)), root)
}

tree.printTree

