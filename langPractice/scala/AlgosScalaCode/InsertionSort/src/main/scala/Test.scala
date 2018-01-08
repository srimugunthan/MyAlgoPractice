/**
  * Created by sdhandap on 12/10/17.
  */
object Test {

  def sort(list: List[Int]): List[Int] = {

    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
      case List() => List(x)
      case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
    }


    list match {
      case List() => List()
      case y :: ys => insert(y, sort(ys))
    }

  }
  def main(args: Array[String]): Unit ={
    val inputList = List(4,6,3,2,5)
    val sortedList = sort(inputList)
    for(i <- sortedList)
      print(i)
  }
}
