/**
  * Created by sdhandap on 1/4/18.
  */
object Test {

  def callByValue(x: Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }

  def callByName(x: => Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }

  def something() = {
    println("calling something")
    1 // return value
  }

  def main(args: Array[String]): Unit = {

   // callByValue(something())
    callByName(something())
  }

}

