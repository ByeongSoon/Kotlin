import com.sun.org.apache.xpath.internal.operations.Bool

fun main(args: Array<String>) {
  testHigher()

  filterTest()

  bindingTest()

  substringTest()
}

fun testFunction() { // 리스트에 있는 요소를 홀수 짝수로 필터링하는 예제
  val ints = listOf(1, 2, 3, 4, 5, 6)

  val evens = mutableListOf<Int>()
  val odds = mutableListOf<Int>()

  for( k in ints){
    if (k % 2 ==0)
      evens.add(k)
    else
      odds.add(k)
  }
}

fun testHigher(){ // 리스트에 있는 요소를 홀수 짝수로 필터링하는 예제 고차 함수의 사용
  val ints = listOf(1, 2, 3, 4, 5, 6)
  val odds = ints.filter { it % 2 == 1 }
  val evens = ints.filter { it % 2 == 0 }

  odds.forEach { println(it) }
  evens.forEach { println(it) }
}

fun bar(): (String) -> String = {str -> str.reversed()} // 문자열 뒤집어서 반환하는 함수를 반환

fun barTest() {
  val reversi = bar()
  reversi("hello")
  reversi("world")
}

fun filterTest() { // 익명 함수 테스트(리터럴과 익명 함수의 비교)
  val ints = listOf(1, 2, 3, 4, 5, 6)
  val evens = ints.filter {it % 2 == 0}
  val evensTwo = ints.filter(fun(k: Int) = k % 2 == 0)

  println(evens.equals(evensTwo))
}

fun isEven(k: Int): Boolean = k % 2 == 0  // 최상위 함수 참조

fun reference() {
  val ints = listOf(1, 2, 3, 4, 5)
  ints.filter { isEven(it) }
}

fun referenceTwo() {
  val ints = listOf(1, 2, 3, 4, 5)
  ints.filter(::isEven)
} // -----------------------------------------------------

fun foo(a: Double, b: Double, f: (Double,Double) -> Double)  = f(a,b) // 멤버 함수를 매개변수로 받을 때

fun fooTest() {
  foo(1.0, 2.0, {a, b -> Math.pow(a,b)})
}//-------------------------------------------------------

fun String.equalsIgnoreCase(other: String) = this.toLowerCase() == other.toLowerCase() // 대소문자 구분없이 동등성 판단 바인더 사용

fun bindingTest() {
  val resultList = listOf("bar","foo", "moo", "boo").filter {
    (String::equalsIgnoreCase)("bar",it)
  }
  resultList.forEach { println(it) }

  var resultListTwo = listOf("bar","foo", "moo", "boo").filter("bar"::equalsIgnoreCase).forEach { println(it) }
}// ------------------------------------------------------

fun foo(fn: String.() -> Boolean): Unit { // 함수 리터럴 수신자
  "string".fn()
}

val substring = fun String.(substr: String): Boolean = this.contains(substr)

fun substringTest() {
  println("hello".substring("ello"))
} // -------------------------------------------------------

