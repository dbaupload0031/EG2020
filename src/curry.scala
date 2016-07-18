/**
  * Created by Administrator on 2016/7/18.
  */
object curry {

  def factorOf(x: Int)(y: Int) = x * y
  val f1= factorOf(5)_
  val f2=factorOf(10) _


  def main(args: Array[String]) = {
    println( f1(10))
    println( f2(10))
  }
}
