/**
  * https://stackoverflow.com/questions/34242536/linearization-order-in-scala
  */
object Test extends App {




  class A {
    print("A")

    def foo() = "A"
  }

  trait B extends A {
    print("B")

    override def foo() =   super.foo() + "B" // Hence I flipped yours to give exact output as constructor
  }

  trait C extends B {
    print("C")

    override def foo() =  super.foo() + "C"
  }

  trait D extends A {
    print("D")

    override def foo() =  super.foo() + "D"
  }

  class X extends A with D with C with B
  var x = new X
  println()
  println(x.foo)

}
