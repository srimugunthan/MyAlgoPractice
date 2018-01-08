/**
  * https://dzone.com/refcardz/scala?fromrel=true
  */
object TestSimple extends App{

  class Recipe(val calories: Int) {

  }
  object Recipe {
    // Assume the client was only guessing the calories and
    // double just in case
    def apply(calories: Int) = new Recipe(calories * 2)
  }
  // This call refers to the Recipe object and is the same as calling Recipe.apply(100)
  val r = Recipe(100)  // apply method is called by default
  println(r.calories)  // outputs 200
}
