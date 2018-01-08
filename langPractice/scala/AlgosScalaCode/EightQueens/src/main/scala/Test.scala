/**
  * Created by sdhandap on 12/10/17.
  */
object Test extends App {

  def nqueens(n: Int): Set[List[Int]] = {
    def place(k: Int): Set[List[Int]] =
      if (k == 0) Set(List())
      else
        for {
          queens <- place(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield queens :+ col

    def isSafe(col: Int, queens: List[Int]): Boolean = {
      val row = queens.length
      val queensWithRow = (0 until row) zip queens
      queensWithRow forall {
        case (r, c) => col != c && math.abs(col - c) != row - r
      }
    }
    place(n)
  }

  def show(queens: List[Int]) = {
    val lines =
      for(col <- queens.reverse)
        yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
    "\n" + (lines mkString "\n")
  }

  print((nqueens(8) take 3 map show) mkString "\n")


}
