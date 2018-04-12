import java.io.InputStream
import java.io.OutputStream
import java.math.BigDecimal

fun main(args: Array<String>) {
  val personTwo = PersonTwo("byeongsoon","jang",25)
  val person = Person("Test","value",null)
  val personThree = PersonThree("bong","jang",25)
  val testClass = A()

  testClass.B().foo("jang")

  val singleTon = Singleton
  for (i in 1..9)
    singleTon.doSomething()

  val test = Test("jang").testFunction()
}

class Person constructor(val firstName:String, val lastName:String, val age:Int?){} // 클래스 만드는 방법 1

class PersonTwo (val firstName: String, val lastName: String, val age: Int?) { // 클래스 만드는 방법 2
  init {
    require(firstName.trim().length > 0) { "Invalid firstName argument."}
    require(lastName.trim().length > 0) { "Invalid lastName argument."}
    if(age != null) {
      require(age >= 0 && age <= 150) { "Invalid age argument."}
    }
  }
}

class PersonThree(firstName: String, lastName: String, age: Int?){// 클래스 만드는 방법 3
private val name: String
  private val age: Int?

  init {
    this.name = "$firstName,$lastName"
    this.age = age
  }

  fun getName(): String = this.name
  fun getAge(): Int? = this.age
}

class A {
  private val somefield: Int = 1
  inner class B {
    private val somefield: Int = 2                                             ;
    fun foo(s: String) {
      println("Field <somefield> from B" + this.somefield)
      println("Field <somefield> from B" + this@B.somefield)
      println("Field <somefield> from B" + this@A.somefield)
    }
  }
}

object Singleton {
  private var count = 0
  fun doSomething(): Unit {
    println("Calling a doSomething (${count++} call/-s in total)")
  }
}

interface Document{
  val version: Long
  val size: Long

  val name: String
    get() = "No Name"

  fun save(input: InputStream)
  fun load(output: OutputStream)
  fun getDescription(): String {
    return "Document $name has $size has $size byte(-s)"
  }
}

class TestClass(override val version: Long, override val size: Long) :Document {
  override fun load(output: OutputStream) {

  }

  override fun save(input: InputStream) {

  }

}

class Test(val name: String){
  init {
    println("init")
  }
  fun testFunction() = println("test")
}



enum class CardType {
  VISA, MASTERCARD, AMEX
}

open class Payment(val amount: BigDecimal)


class CardPayment : Payment {
  constructor(amount: BigDecimal, number: String, type: CardType) : super(amount)
}
