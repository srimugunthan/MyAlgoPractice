/**
  * http://www.scala-lang.org/old/node/117
  */
object Test2 extends App{


    class Iter extends StringIterator(args(0)) with RichIterator
    val iter = new Iter
    iter foreach println


}
abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next: T
}


trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit) { while (hasNext) f(next) }
}

class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0
  def hasNext = i < s.length()
  def next = { val ch = s charAt i; i += 1; ch }
}

