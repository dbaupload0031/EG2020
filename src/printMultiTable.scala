/**
  * Created by samchang on 2016/7/17.
  */
object printMultiTable {
  /* def multiprint01(a: Int)= {
     for (x <- 1 to a)
      {
        for (y <- 1 to a)
          {
            print(  " " * (4- getsize(x*y) ) + (x*y)  )

          }
        print("\n")
      }
   }
 */

  def getsize(x: Int) = {
    x.toString.length
  }

  def multiprint01(a: Int, len: Int) = {
    for (y <- 1 to len) {
      print(" " * (4 - getsize(a * y)) + (a * y))
    }
  }

  def multiprint02(a: Int) = {
    for (y <- 1 to a) {
      multiprint01(y, a)
      print("\n")
    }
  }

  def main(args: Array[String]) = {
    multiprint02(10)
  }
}
