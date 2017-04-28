package exercise


sealed abstract class BinaryTree[+T]

case object Nil extends BinaryTree

case class Leaf[+T](value: T) extends BinaryTree[T]

case class Branch[+T](value: T, left: BinaryTree[T], right: BinaryTree[T]) extends BinaryTree[T]



object BinaryTree {

  def depth[T](tree: BinaryTree[T]): Int = tree match {
    case Nil => 0
    case Leaf(_) => 1
    case Branch(_, left, right) =>
      (depth(left) max depth(right)) + 1
  }

  def members[T](tree: BinaryTree[T]): Int = tree match {
    case Nil => 0
    case Leaf(_) => 1
    case Branch(_, left, right) => (members(left) + members(right))
  }

  private def insertBalanced[T <% Ordered[T]](tree: BinaryTree[T], value: T) : BinaryTree[T] = tree match {
    case Nil => Leaf(value)
    case Leaf(v) => if (v < value) Branch(v, Nil, Leaf(value)) else Branch(v, Leaf(value), Nil)
    case Branch(v, left, right) =>
      if (v < value)
        Branch(v, left, insertBalanced(right, value))
      else
        Branch(v, insertBalanced(left, value), right)
  }

  def balanced[T <% Ordered[T]](members: Array[T]): BinaryTree[T] =
    members.foldLeft(Nil: BinaryTree[T])(insertBalanced)
}
