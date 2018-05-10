import com.sun.tools.jdi.BooleanValueImpl
import javax.print.attribute.standard.MediaSize

fun foo(str: String, fn: (String) -> String):Unit {
  val applied = fn(str)
  println(applied)
}

fun main(args: Array<String>) {
  val ints = listOf(1,2,3,4,5,6)

  val evens = mutableListOf<Int>()
  val odds = mutableListOf<Int>()

  for (k in ints) {
    if (k % 2 == 0)
      evens.add(k)
    else
      odds.add(k)
  }

  val oddsTwo = ints.filter { it % 2 == 1 }
  val evensTwo = ints.filter { it % 2 == 0 }
}

fun bar(): (String) -> String = { str -> str.reversed() }
fun barTest() {
  val reversi = bar()
  reversi("hello")
  reversi("world")
}

fun modulo(k: Int): (Int) -> Boolean = { it % k == 0 }

fun moduloTest() {
  val ints = listOf(1,2,3,4,5,6)
  //val odds = ints.filter(modulo(1))
  val evens = ints.filter(modulo(2))
  val mod3 = ints.filter(modulo(3))

  val isEven: (Int) -> Boolean = modulo(2)

  listOf(1,2,3,4).filter(isEven)
  val test = {message: String -> println(message)}
}

fun closure() {
  var containNegative = false
  var ints = listOf(1,2,3,4,5,6)
  ints.forEach {
    if (it < 0)
      containNegative = true
  }
}

fun anonymous() {
  val ints = listOf(1,2,3,4)
  val evens = ints.filter(fun(k: Int) = k % 2 == 0)
  val evensTwo = ints.filter(fun(k) = k % 2 == 0)
}

fun isEven(k: Int): Boolean = k % 2 == 0
fun isEvenTest() {
  val ints = listOf(1,2,3,4,5)
  ints.filter { isEven(it) }
  ints.filter(::isEven)
}

fun Int.isOdd(): Boolean = this % 2 == 1
fun isOddTest() {
  val ints = listOf(1,2,3,4,5)
  ints.filter { it.isOdd() }
  ints.filter(Int::isOdd)
}

fun foo2(a: Double, b: Double, f: (Double,Double) -> Double) = f(a,b)
fun foo2Test() {
  foo2(1.0, 2.0, { a,b -> Math.pow(a,b) })
  foo2(1.0, 2.0, Math::pow)
}

fun String.equalsIgnoreCase(other: String) = this.toLowerCase() == other.toLowerCase()
fun equalsTest() {
  listOf("bar","foo","moo","boo").filter {
    (String::equalsIgnoreCase)("bar",it)
  }
  listOf("bar","foo","moo","boo").filter("bar"::equalsIgnoreCase)
}