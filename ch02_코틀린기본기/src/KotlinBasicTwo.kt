
import java.io.File
import java.io.IOException
import java.math.BigDecimal
import java.net.Inet4Address
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


fun main(args: Array<String>) {
  val name = "byeongsoon"                   
  val concat = "Hello" + name
  val concatTwo = "Hello $name"
  val length = "Name length is ${name.length}"

  println(concatTwo)
  println(length)

  val aToz = "a".."z"
  val isTrue = "c" in aToz

  val oneToNine = 1..9

  val countingDown = 100.downTo(0)
  val rangTo = 10.rangeTo(20)

  val oneToFifty = 1..50
  val range = oneToFifty.step(2)

  //range.forEach { print(it) }

  val countiungDownEvenNumber = (2..100).step(2).reversed()
  //countiungDownEvenNumber.forEach { print(it ) }

//  while (true) {
//
//  }

  val list = arrayOf(1,2,3,4)

  for (k in list){
    println(k)
  }

  list.forEach { print(it) }

  list.forEach { k -> print(k) }

  for (k in 2..9){
    for (m in 2..9){
      println("$k x $m = ${k*m}")
    }
    println()
  }

  val file = File("/etc/nginx/nginx/conf")
  val data = BigDecimal(100)

  val test = Test(1,2)

  val a = File("test.txt")
  val b = a

  println(a===b)

  val c = "test"
  val d = "test"

  println(c==d)

  Person("jang").printMe()

  "Hello".startsWith("H")
  val f = 1

  val success = try {
    readFile(Paths.get("./src/BasicTest.kt"))
    true
  } catch (e: IOException) {
    false
  }

  val str: String = "test"

  println(isString(str))

  val x = 0
  val y = 1
  when(x){
    0,1 -> println("x is Zero")
    else -> println("x is neither 0 nor 1")
  }

  val test2 = when(x) {
    0 -> true
    else -> false
  }

  printUntilStop()
}
fun printUntilStop() {
  val list = arrayOf("a","b","stop","c")
  list.forEach stop@{
    if(it == "stop") return@stop
    else println(it)
  }
}
fun printUntilStop3() {
  val list = arrayOf("a","b","stop","c")
  list.forEach {
    if(it == "stop") return@forEach
    else println(it)
  }
}


fun isString(any: Any): Boolean {
  return any is String
}
fun printStringLength(any: Any){
  if(any is String){
    println(any.length)
  }
}

fun isEmptyString(any: Any): Boolean {
  return any is String && any.length == 0
}

fun length(any : Any):Int{
  val string = any as String
  return string.length


}

fun isZero(x: Int): Boolean{
  return if(x==0) true else false
}


internal class Person(name: String){
  fun printMe() = println(this)
}

class Building(val address: String){
  inner class Reception(telephone: String) {
    fun printAddress() = println(this@Building.address)
  }
}

class Test (x: Int, y: Int) {}

//class Test {
//  int x;
//  int y;
//  Test(int x, int y) {
//    this.x = x;
//    this.y = y;
//  }
//}

fun readFile(path: Path): Unit {
  val input = Files.newInputStream(path)
  try {
    var byte = input.read()
    while (byte != -1){
      println(byte)
      byte = input.read()
    }
  } catch (e: IOException) {
    println("Error")
  } finally {
    input.close()
  }


}