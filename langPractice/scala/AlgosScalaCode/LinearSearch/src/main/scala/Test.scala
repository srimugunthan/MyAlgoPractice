/**
  * Created by sdhandap on 12/10/17.
  * https://stackoverflow.com/questions/9556579/finding-an-item-that-matches-predicate-in-scala
  */
object Test {

  def lookfor() = {
    val l = List(1, 2, 3, 4)

    val lookfor = 5
    val res = (l.find(x => x == lookfor))
    res match {
      case Some(x) => "Y";
      case _ => "N"
    }
  }



  def main(args: Array[String]): Unit ={

    print(lookfor())

  }


}
