/**
  * Created by Administrator on 2016/7/18.
  */
object literal01 {

  // function literal(Anonymous Functions)
  // pass it into a method that takes a function, or to assign it to a variable
  val increase = (x: Int) => {
    println("We")
    println("are")
    println("here!")
    x + 1
    //println(s"$x")
  }

  val someNumbers = List(-11, -10, -5, 0, 5, 10)

  def main(args: Array[String]) = {
  // println(increase(10))
    someNumbers.foreach( (x: Int) => print(x + "  "))
   println("")
    val k3 = someNumbers.filter( (x:Int) => x > 5)
    println(k3)
   //target typing
   val k4 = someNumbers.filter( (x) => x > 5)
   println(k4)

    val k5 = someNumbers.filter( x => x > 5)
    println(k5)

    val k6 = someNumbers.filter( _ > 5)
    println(k6)
  }


}
