/**
  * Created by sdhandap on 10/9/17.
  */

//4 uses of Apply
//https://blog.matthewrathbone.com/2017/03/06/scala-object-apply-functions.html
//https://stackoverflow.com/questions/9737352/what-is-the-apply-function-in-scala
//https://twitter.github.io/scala_school/basics2.html
//http://www.informit.com/articles/article.aspx?p=1849235&seqNum=6
// commonidiom for constructing obje
//http://www.informit.com/articles/article.aspx?p=1849235&seqNum=6

/**
  * A Scala Factory Pattern example by Alvin Alexander,
  * http://devdaily.com
  */

//https://alvinalexander.com/scala/factory-pattern-in-scala-design-patterns
trait Animal {
  def speak
}

object Animal {

  private class Dog extends Animal {
    override def speak { println("woof") }
  }

  private class Cat extends Animal {
    override def speak { println("meow") }
  }

  // my preferred factory method
  def apply(s: String):Animal = {
    if (s == "dog") return new Dog
    else return new Cat
  }

  // an alternative factory method (use one or the other)
  def getAnimal(s: String):Animal = {
    if (s == "dog") return new Dog
    else return new Cat
  }

}



object Test extends App{
  val dog = Animal("dog")
  dog.speak

  val cat = Animal("cat")
  cat.speak

  Animal.getAnimal("dog").speak
  Animal.getAnimal("cat").speak

}
