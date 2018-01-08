/**
  *https://alvinalexander.com/scala/scala-trait-examples
  */

trait Tail {
  def wagTail { println("tail is wagging") }
}

abstract class Pet (var name: String) {
  def speak  // abstract
  def ownerIsHome { println("excited") }
}

class Dog (name: String) extends Pet (name) with Tail {
  def speak { println("woof") }
}

object Test extends App {


  val zeus = new Dog("Zeus")
  println(zeus.ownerIsHome)
  println(zeus.wagTail)
  println(zeus.speak)


}
