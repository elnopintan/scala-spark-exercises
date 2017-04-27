package exercise


sealed abstract class BinaryTree[+T]

case object Nil extends BinaryTree

case class Leaf[+T](value: T) extends BinaryTree[T]

case class Branch[+T](value: T, left: BinaryTree[T], right: BinaryTree[T]) extends BinaryTree[T]



object BinaryTree {

  def depth[T](tree: BinaryTree[T]): Int = ???

  def members[T](tree: BinaryTree[T]): Int = ???

  private def insertBalanced[T <% Ordered[T]](tree: BinaryTree[T], value: T) : BinaryTree[T] = ???

  def balanced[T <% Ordered[T]](members: Array[T]): BinaryTree[T] = ???
}