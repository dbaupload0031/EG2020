/**
  * Created by samchang on 2016/7/16.
  */
class class01 {

}

object test002 {

  class Rational(n: Int, d: Int) {
    override def toString = n + "/" + d
  }

  def main(args: Array[String]) = {
    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)

  }
}