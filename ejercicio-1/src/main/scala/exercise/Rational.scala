package exercise

class Rational(n: Int, d: Int) {

  val numer: Int = ???

  val denom: Int = ???

  override def toString: String = ???

  def +(that: Rational): Rational = ???

  def /(that: Rational): Rational = ???

  def this(n: Int) = this(0,0) // Fix it

  private def gcd(a: Int, b: Int): Int = ???
}


