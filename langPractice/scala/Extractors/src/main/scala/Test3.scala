/**
  * http://danielwestheide.com/blog/2012/11/21/the-neophytes-guide-to-scala-part-1-extractors.html
  */
object Test3 extends App{


  trait User {
    def name: String
  }

  class FreeUser(val name: String) extends User

  class PremiumUser(val name: String) extends User

  object FreeUser {
    def unapply(user: FreeUser): Option[String] = Some(user.name)
  }

  object PremiumUser {
    def unapply(user: PremiumUser): Option[String] = Some(user.name+"xxx")
  }

  val user: User = new PremiumUser("Daniel")
  user match {
    case FreeUser(name) => println("Hello " + name)
    case PremiumUser(name) => println("Welcome back, dear " + name)
  }
}