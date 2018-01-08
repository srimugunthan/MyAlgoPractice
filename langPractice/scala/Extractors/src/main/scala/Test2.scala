/**
  * https://docs.scala-lang.org/tour/extractor-objects.html
  */
import scala.util.Random

object Test2 extends App{

  object CustomerID {

    def apply(name: String) = {s"$name--${Random.nextLong}"
 }

    def unapply(customerID: String): Option[String] = {
      val name = customerID.split("--").head
      if (name.nonEmpty) Some(name) else None
    }
  }


  val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908
  println(customer1ID)
  customer1ID match {
    case CustomerID(name) => println(name)  // prints Sukyoung
    case _ => println("Could not extract a CustomerID")
  }
}




