/**
  * Created by Administrator on 2016/7/18.
  */
object TailRecurse {

  @annotation.tailrec
  def power(x: Int, n: Int, total: Int = 1): Int = {
    if (n < 1) total
    else power(x, n-1, x*total)
  }

  def main(args: Array[String]) = {
   println( power(2,8) )
  }
}
