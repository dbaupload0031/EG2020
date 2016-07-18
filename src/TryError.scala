/**
  * Created by samchang on 2016/7/17.
  */
object TryError {

  import java.io.{FileNotFoundException, FileReader, IOException}

  def fread(x: String) = {

    try {
      val f = new FileReader(x)
      val f2 = f.read()

    } catch {
      case ex: FileNotFoundException => println("Handle missing file")
      case ex: IOException => println(" Handle other I/O error")
      case _ => println("Unknown")
    }
    finally {
      println("done...finally.")
    }
  }

  def main(args: Array[String]) = {
    fread("kkk.txt")
  }
}
