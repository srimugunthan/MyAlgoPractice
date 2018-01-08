/**
  * http://www.scala-lang.org/old/node/111
  */
object Test extends App {


    def even(from: Int, to: Int): List[Int] =
      for (i <- List.range(from, to) if i % 2 == 0) yield i



    Console.println(even(0, 20))


}
