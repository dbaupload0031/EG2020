/**
  * Created by samchang on 2016/7/17.
  */

class Rational(val n: Int, val d: Int) {
  /*
  The require method takes one boolean parameter. If the passed value is
true, require will return normally. Otherwise, require will prevent the ob-
ject from being constructed by throwing an IllegalArgumentException.
   */
  require(d != 0)

  //println(n +"/"+ d)
  override def toString = {
    if (d == 1) n.toString else n / (gcd(n, d)) + "/" + d / (gcd(n, d))
  }

  def add(that: Rational): Rational =
    new Rational(n * that.d + that.n * d, d * that.d)

  def multi(that: Rational): Rational =
    new Rational(n * that.n, d * that.d)

  //overloading
  def multi(that: Int): Rational =
    new Rational(n * that, d)

  def lessThan(that: Rational) =
    that.n * d < that.d * n

  def max(that: Rational) =
    if (that.n * d < that.d * n) that else this


  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)


  //constructor
  def this(n: Int) = this(n, 1)
}

object RationalStuff {

  def main(args: Array[String]) = {
    val oneHalf = new Rational(5, 1)
    println(oneHalf)
    val twoThirds = new Rational(2, 3)
    val total01 = oneHalf.add(twoThirds)
    println(total01)
    val total02 = oneHalf.lessThan(twoThirds)
    println(total02)
    val total03 = oneHalf.max(twoThirds)
    println(total03)
    val total04 = new Rational(20, 88)
    println(total04)
    val total05 = oneHalf.multi(twoThirds)
    println(total05)
    val total06 = oneHalf.multi(3)
    println(total06)

    //auto convert
    implicit def intToRational(x: Int) = new Rational(x)
    val total07 = 3 multi (oneHalf)
    println(total07)

  }
}


