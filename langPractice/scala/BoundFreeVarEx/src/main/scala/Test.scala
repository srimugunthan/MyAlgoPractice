

object Test  {

  def main(args:Array[String]): Unit = {
    println( "Divided value = " + divider(4) )
    println( "Divided value = " + divider(6) )
    println( "Divided value = " + divider(8) )
    println( "Divided value = " + divider(10) )
  }

  var div = 2
  val divider = (i:Int) => i/div

}
//https://www.journaldev.com/7751/scala-closures-free-and-bound-variables-anonymous-functions

val result = (i:Int) => i * 6

class Marks(m1: Int) {

  var marks : Int = m1

  def totalmarks(ma1:Int) {
    marks = marks+10
    println("Total marks secured: " +marks)
  }
}

object m1 {

  def main(args:Array[String]) {
    var m1 = new Marks(45)
    m1.totalmarks(45)
  }
}

