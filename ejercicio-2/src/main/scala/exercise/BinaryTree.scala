package exercise

sealed abstract class BinaryTree {

  def depth: Int
  def members: Int
  def insertBalanced(value: Int): BinaryTree
  override def toString: String // Prints tree elements

}

object Nil extends BinaryTree {
  override def depth: Int = 0

  override def members: Int = 0

  override def insertBalanced(value: Int): BinaryTree = new Leaf(value)
}

class Leaf(value: Int) extends BinaryTree {
  override def depth: Int = 1

  override def members: Int = 1

  override def insertBalanced(v: Int): BinaryTree =
    if (v < value)
      new Branch(value, new Leaf(v), Nil)
    else
      new Branch(value, Nil, new Leaf(v))
}

class Branch(value: Int, left: BinaryTree, right: BinaryTree) extends BinaryTree {
  override def depth: Int = (left.depth max right.depth) + 1

  override def members: Int = left.members + right.members + 1

  override def insertBalanced(v: Int): BinaryTree =
    if (v < value)
      new Branch(value, left.insertBalanced(v), right)
    else
      new Branch(value, left, right.insertBalanced(v))

}

object BinaryTree {
  def leaf(value: Int): BinaryTree = new Leaf(value)
  def branch(value: Int, left: BinaryTree, right: BinaryTree): BinaryTree = new Branch(value, left, right)
  def buildBalanced(nodes: Array[Int]): BinaryTree = {
    var tree: BinaryTree = Nil
    var i = 0
    while (i < nodes.length) {
      tree = tree.insertBalanced(nodes(i))
      i += 1
    }
    tree
  }
}