import java.awt.Shape
import java.math.BigDecimal
import java.util.*
import kotlin.math.log

fun <T: Comparable<T>> min(first: T, second: T): T {
  val k = first.compareTo(second)
  println(k)
  return if (k <= 0) first else second
}

fun main(args: Array<String>) {
  val a: Int = min(4, 5)
  val b: String = min("e", "c")

  println(a)
  println(b)

//  val oraanges = Crate(mutableListOf(Orange(), Orange()))
//  foo(oraanges)
//  val orange: Orange = oraanges.last()

//  val oranges = Crate(mutableListOf(Orange(), Orange()))
//  isSafe(oranges)

  val oranges = CovariantCrate(listOf(Orange(), Orange()))
  isSafe(oranges)

  EventStreamTest()
}

class CovariantCrate<out T>(val elements: List<T>) {
  fun last(): T = elements.last()
}

open class Fruit {
  fun isSafeToEat(): Boolean = true
}

fun isSafe(crate: CovariantCrate<Fruit>): Boolean = crate.elements.all {
  it.isSafeToEat()
}

class Apple: Fruit()
class Orange: Fruit()

class Crate<T>(val elements: MutableList<T>) {
  fun add(t: T) = elements.add(t)
  fun last(): T = elements.last()
}

fun foo(crate: Crate<Fruit>) {
  crate.add(Apple())
}

open class Animal
class Sheep: Animal()
class Frog: Animal()

abstract class Farm {
  abstract fun get(): Animal
}

abstract class SheepFarm: Farm() {
  abstract override fun get(): Animal
}

//-------------------반공변성--------------------------------

interface Listener<in T> {
  fun onNext(t: T): Unit
}

class EventStream<in T>(val listener: Listener<T>) {
  fun start(): Unit = println("start")
  fun stop(): Unit = println("stop")
}

fun EventStreamTest() {
  val stringListener = object: Listener<String> {
    override fun onNext(t: String) = println(t)
  }
  val stringStream = EventStream<String>(stringListener)
  stringStream.start()

// 여기 까지는 괜찮아 보인다. 또 다른 스트림을 만들어보자.
  val dateListener = object: Listener<Date> {
    override fun onNext(t: Date) = println(t)
  }
  val dateStream = EventStream<Date>(dateListener)
  dateStream.start()

  val loggingListner = object: Listener<Any> {
    override fun onNext(t: Any) {
      println(t)
    }
  }

  val stringStreamTwo = EventStream<String>(loggingListner)

  EventStream<Double>(loggingListner).start()
  EventStream<BigDecimal>(loggingListner).start()
  EventStream<Pair<String,String>>(loggingListner).start()
  EventStream<Date>(loggingListner).start()

}
