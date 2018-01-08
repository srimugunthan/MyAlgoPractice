//https://www.javatpoint.com/scala-singleton-and-companion-object
//http://blogs.tedneward.com/patterns/Singleton-Scala/
class Test{
  def hello(){
    println("Hello, this is Companion Class.")
  }
}
object Test{
  def main(args:Array[String]){
    new Test().hello()
    println("And this is Companion Object.")
  }
}