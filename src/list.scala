/**
  * Created by samchang on 2016/7/16.
  */
object list {
  def main(args: Array[String]) = {
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(oneTwoThreeFour)

    val twoThree = List(7, 8)
    /*
    ‘::’, which is pronounced “cons.” Cons prepends a new element to the beginning of an
      existing list, and returns the resulting list.

      method is invoked on the left operand, as in a.*(b)—unless the method
name ends in a colon. If the method name ends in a colon, the method is
invoked on the right operand. Therefore, in 1 :: twoThree, the :: method
is invoked on twoThree, passing in 1, like this: twoThree.::(1).
      */
    val oneTwoThree = 1 :: twoThree
    println(oneTwoThree)

    val new01 = 1 :: 2 :: 30 :: Nil
    println(new01)
    val new02 = 1332 :: 25555 :: 3509 :: 77777 :: 888888 :: List()
    println(new02.count(s => s.toString.length == 4))
    val thrill = "Will" :: "fill" :: "until" :: "d" :: "j" :: "e" :: Nil
    //counts the number of list elements ONLY for String List
    println(thrill.count(s => s.length == 4))
    println(thrill.head)
    println(thrill.last)
    println(thrill.length)
    println(thrill.map(x => x + "good"))
    println(thrill.mkString(","))
    println(thrill.tail(0))
  }
}
