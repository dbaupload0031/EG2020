/**
  * Created by samchang on 2016/7/21.
  */
object callByName {

  def time() = {
    println("获取时间，单位为纳秒")
    System.nanoTime
  }
  def delayed( t: => Long ) = {
    println("在 delayed 方法内")
    println("参数： " + t)

  }

  var flag: Boolean = true
  def useOrNotUse(x: Int, y: => Int) = {
    flag match{
      case true => x
      case false => x + y
    }
  }

  def main(args: Array[String]) {
    delayed(time());
    println("-------------------")
    println(useOrNotUse(1, 2)) //no necessary to invoke 2
    flag = false
    println(useOrNotUse(1, 2))


  }


}
