/**
  * Created by Administrator on 2016/7/18.
  */
object literal01 {

  // function literal
  val increase = (x: Int) => {
    println("We")
    println("are")
    println("here!")
    x + 1
    //println(s"$x")
  }

  def main(args: Array[String]) = {
   println(increase(10))
  }
}
