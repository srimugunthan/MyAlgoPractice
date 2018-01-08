/**
  *https://dzone.com/articles/dealing-with-diamond-problem-in-java
  */
object Test3  extends App{

  trait A{
    def foo = {println(" trait A")}

  }

  trait B {
    def foo = { println("trait B")}
  }

  class D extends A with B {
    override def foo: Unit = super.foo
  }


  val d = new D
  d.foo

}
