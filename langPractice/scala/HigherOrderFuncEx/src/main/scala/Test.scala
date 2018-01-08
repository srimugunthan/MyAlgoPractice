/**
  * Created by sdhandap on 1/4/18.
  */
object Test  extends App{
  def cube(x: Int): Int = x * x * x
  def id(x: Int): Int = x


  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)


  def sumInts(a: Int, b: Int): Int = sum(id, a, b)
  def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)

  println(sumCubes(4,6))
  println(sumInts(3,2))

}

