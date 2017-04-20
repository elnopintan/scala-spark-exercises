package exercise

sealed abstract class BinaryTree {

  def depth: Int
  def members: Int
  def insertBalanced(value: Int): BinaryTree
  override def toString: String // Prints tree elements

}


object BinaryTree {
  def leaf(value: Int): BinaryTree = ???
  def branch(value: Int, left: BinaryTree, right: BinaryTree): BinaryTree = ???
  def buildBalanced(nodes: Array[Int]): BinaryTree = ???
}