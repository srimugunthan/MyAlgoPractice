//https://stackoverflow.com/questions/609744/what-is-the-rationale-behind-having-companion-objects-in-scala
//http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-tutorial-learn-create-use-companion-objects/
//https://docs.scala-lang.org/tour/singleton-objects.html
abstract class AnimalCounter
{
  var animals = 0

  def name: String

  def count()
  {
    animals += 1
    println("%d %ss created so far".format(animals, name))
  }
}

abstract class Animal
{
  def companion: AnimalCounter
  companion.count()
}

object Dog extends AnimalCounter
{
  val name = "dog"
}

class Dog extends Animal
{
  def companion = Dog
}

object Cat extends AnimalCounter
{
  val name = "cat"
}

class Cat extends Animal
{
  def companion = Cat
}

object Test extends App{

  val x = new Dog()
  val y = new Cat()
}
