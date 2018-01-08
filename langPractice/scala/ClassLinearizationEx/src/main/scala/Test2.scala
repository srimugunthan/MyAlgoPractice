/**
  * Created by sdhandap on 1/5/18.
  */
object Test2 extends App{


  trait A{
    def display(){ println("From A.display")  }
  }
  trait B extends A{
    override def display() { println("From B.display") }
  }
  trait C extends A{
    override def display() { println("From C.display") }
  }
  class D extends B with C{ }



  val d = new D
  d display
}

