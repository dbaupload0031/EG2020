/**
  * Created by Administrator on 2016/7/18.
  */
object HighOrder {

  //opion1: put function name directly
  def safeStringOp(s: String, f: String => String) = {
    if (s != null) f(s) else s
  }

  def reverser(s: String) = s.reverse

  //options3
  val uuid = java.util.UUID.randomUUID.toString


  def main(args: Array[String]) = {
    println(safeStringOp("TATA", reverser))

    //option2:(Function Literal)
    println(safeStringOp("Sam1", (s: String) => s.reverse))
    println(safeStringOp("Sam2", (s) => s.reverse))
    println(safeStringOp("Sam3", (s: String) => s.reverse))
    println(safeStringOp("Sam4", _ reverse))

    println("---------------option3")
    println(uuid)
    val timedUUID = safeStringOp(uuid, { s =>
      val now = System.currentTimeMillis
      val timed = s.take(24) + now
      timed.toUpperCase
    } )
    println(timedUUID)

  }
}
