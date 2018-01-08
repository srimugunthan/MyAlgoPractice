/**
  * Created by sdhandap on 8/18/17.
  */
object Test {



  def apply(fname: String, lname: String) = {
    fname + " " + lname
  }

  def unapply(s: String): Option[(String, String)] = {
    val pts = s split " "
    if (pts.length == 2) {
      Some(pts(0), pts(1))
    } else {
      None
    }
  }

  def main(args: Array[String]) {

    println("Apply method : " + apply("Steve", "Smith"));
    println("Unapply method : " + unapply("Steve Smith"));
    println("Unapply method : " + unapply("Rob"));

  }

}
