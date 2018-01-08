import scala.annotation.tailrec

/**
  * Created by sdhandap on 12/10/17.
  */
object Test {

  type Index = Int

  def binarySearch(ds: Array[Double], key: Double): Option[Index] = {
    @tailrec
    def go(lo: Index, hi: Index): Option[Index] = {
      if (lo > hi)
        None
      else {
        val mid: Index = lo + (hi - lo) / 2
        ds(mid) match {
          case mv if (mv == key) => Some(mid)
          case mv if (mv < key) => go(mid +1, hi)
          case _ => go(lo, mid-1 )
        }
      }
    }

    go(0, ds.size - 1)

  }

  def main(args: Array[String]): Unit = {
    val ds =Array(2.0, 3.3, 5.0,52.0)

    print(binarySearch(ds, 5.0))
  }

}
