fun main(args: Array<String>) {
  var testString = "hello"
  var testLength = testString.length

  println(testLength)
  println(testString.take(5))

  val originalList = arrayOf(1,2,3,4,5,6)
  val newList = originalList.drop(3)
  val test = originalList.dropLast(3)

  originalList.forEach { print("$it ") }
  println()
  newList.forEach { print("$it ") }
  println()
  test.forEach { print("$it ") }
  println()

  println(testString.reversed())
}

fun fizzbuzz1(start: Int, end: Int): Unit {
  for( k in start..end) {
    if( k % 3 == 0 && k % 5 == 0)
      println("Fizz Buzz")
    else if( k % 3 == 0)
      println("Fizz")
    else if( k % 5 == 0)
      println("Buzz")
    else
      println(k)
  }
}

fun fizzbuzz2(start: Int, end: Int): Unit {

  fun isFizz(k: Int): Boolean = k % 3 == 0
  fun isBuzz(k: Int): Boolean = k % 5 == 0

  for( k in start..end) {
    if( isFizz(k) && isBuzz(k))
      println("Fizz Buzz")
    else if( isFizz(k) )
      println("Fizz")
    else if( isBuzz(k) )
      println("Buzz")
    else
      println(k)
  }
}

fun fizzbuzz3(start: Int, end: Int): Unit {

  for( k in start..end) {

    fun isFizz(): Boolean = k % 3 == 0
    fun isBuzz(): Boolean = k % 5 == 0

    if( isFizz() && isBuzz())
      println("Fizz Buzz")
    else if( isFizz() )
      println("Fizz")
    else if( isBuzz() )
      println("Buzz")
    else
      println(k)
  }
}

fun fizzbuzz4(start: Int, end: Int): Unit {
  for (k in start..end) {
    fun isFizz(): Boolean = k % 3 == 0
    fun isBuzz(): Boolean = k % 5 == 0

    when {
      isFizz() && isBuzz() -> println("Fizz Buzz")
      isFizz() -> println("Fizz")
      isBuzz() -> println("Buzz")
      else -> println(k)
    }
  }
}

abstract class DroppableList<E>  : ArrayList<E>() {
  fun drop(k : Int): List<E> {
    val resultSize = size - k
    when {
      resultSize <= 0 -> return emptyList()
      else -> {
        val list = ArrayList<E>(resultSize)
        for (index in k..size-1) {
          list.add(this[index])
        }
        return list
      }
    }
  }
}

fun <E> drop(k : Int, list: List<E>): List<E> {
  val resultSize = list.size - k
  when {
    resultSize <= 0 -> return emptyList<E>()
    else -> {
      val newlist = ArrayList<E>(resultSize)
      for (index in k..list.size - 1) {
        newlist.add(list[index])
      }
      return newlist
    }
  }
}

fun <E> List<E>.drop(k : Int): List<E> {
  val resultSize = size - k
  when {
    resultSize <= 0 -> return emptyList<E>()
    else -> {
      val list = ArrayList<E>(resultSize)
      for (index in k..size - 1) {
        list.add(this[index])
      }
      return list
    }
  }
}

fun Any?.safeEquals(other: Any?): Boolean {
  if(this == null && other == null) return true
  if(this == null) return false
  return this.equals(other)
}

