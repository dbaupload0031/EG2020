

/**
  * Created by samchang on 2016/7/17.
  */
object control {

  def main(args: Array[String]) = {
    val dname = if (5 > 3) "good" else "no luck"
    println(dname)
    println(if (5 > 3) "good1" else "no luck")
    //because filesHere is an Array[File]
    //The for expression syntax works for any kind of collection
    val filesHere = (new java.io.File(".")).listFiles
    for (x <- filesHere)
      println(x)
    //file should be saved to UTF8 format instead.
    def fileLines(file: java.io.File) =
      scala.io.Source.fromFile(file).getLines.toList

    //fileLines("news.txt")

    def grep(pattern: String) =
      for (
        file <- filesHere if file.getName.endsWith(".txt");
        line <- fileLines(file) if line.trim.matches(pattern)
      )
      //println(file +": "+ line.trim)
        yield file + ": " + line.trim
    val k2 = grep(".*300.*")
    for (x <- k2) println(x)

    /*
     .        : Match any character except newline
     ruby*    : Match "rub" plus 0 or more ys
     ".*300.*"  EQUAL *300* IN SCRIPT
     */


    val list01 = List(1, 2, 5, 7, 9)
    for (x <- list01)
      println(x + 1)

    //range type
    for (x <- 1 to 5)
      println(x + 1)
    //means 1 to 4
    for (x <- 1 until 5)
      println(x + 1)

    // for loop with filter
    val filesHere1 = List("abc", "Sam", "kyale", "Smith")
    for (x <- filesHere1
         if x.length > 3;
         if x.startsWith("k");
         if x.endsWith("e"))
      println(x)
  }


}
