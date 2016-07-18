/**
  * Created by samchang on 2016/7/18.
  */
/**
  * Created by samchang on 2016/7/17.
  */
object log1 {

  import scala.io.Source

  def processFile(filename: String, width: Int) {
    //local function can access the parameter of their enclosing function
    def processLine(line: String) {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines)
      processLine(line)


  }

  def main(args: Array[String]) = {
    processFile("D:/CloudData/GoogleDrive/Hadoop2/IDEAProject/scala001/myFirstScalaProject/news.txt", 10)
  }
}
