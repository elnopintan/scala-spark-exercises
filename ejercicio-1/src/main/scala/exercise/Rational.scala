package exercise

class Rational(n: Int, d: Int) {

  val numer: Int = n/gcd(n,b)

  val denom: Int = d/gcd(n,b)

  override def toString: String = s"$numer/$denom"

  def +(that: Rational): Rational =
    new Rational(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom)

  def /(that: Rational): Rational = new Rational(this.numer * that.denom, this.denom * that.numer)

  def this(n: Int) = this(n,1) // Fix it

  private def gcd(a: Int, b: Int): Int = if b == 0 a else gcd(b, a % b)
}


