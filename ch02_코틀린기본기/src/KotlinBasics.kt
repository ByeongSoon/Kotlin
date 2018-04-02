fun main(args: Array<String>) {
    var name = "Beyongsoon Jang" // var 변수 초기화
    println(name)

    println()

    var email: String           // 선언 후 초기화
    email = "byeongsoon@wisoft.io"
    println(email)

    println()

    val languge = "Kotlin"      // read-only 변수 선언
    println(languge)

    println()

    println(plusOne(5))     // 타입추론 - 한 줄짜리 함수 호출

    println()

    val int = 123               // 숫자 리터럴
    val long = 123456L
    val double = 12.34
    val float = 12.34F
    val hexadecimal = 0xAB
    val binary = 0b01010101

    println(int)
    println(long)
    println(double)
    println(float)
    println(hexadecimal)
    println(binary)

    println()

    val intTest = 123           // 타입 변환
    val longTest = intTest.toLong()
    val floatTest = 12.34F
    val doubleTest = floatTest.toDouble()

    println(longTest)
    println(doubleTest)

    println()

    val leftShift = 1 shl 2     // 비트 연산자
    val rightShift = 1 shr 2
    val unsignedRightShift = 1 ushr 2

    val and = 1 and 0x00001111
    val or = 1 or 0x00001111
    val xor = 1 xor 0x00001111
    val inv = 1.inv()           // 역은 단항 연산자이기 때문에 숫자에 점 연사자를 사용해 호출
    println(leftShift)
    println(rightShift)
    println(unsignedRightShift)
    println(and)
    println(or)
    println(xor)
    println(inv)

    println()

    val x = 1                   // 불리
    val y = 2
    val z = 2

    val isTrue = x < y && x < z
    val alsoTrue = x == y || y == z

    println(isTrue)
    println(alsoTrue)

    println()

    val char = 'A'// 문자
    val charTest = 'B'

    println(char)
    println(charTest)

    println()

    val string = "string with \nnew line"       // 문자열

    println(string)

    val rawString = """raw string is super useful for strings that span many lines"""

    println(rawString)

    var array = arrayOf(1, 2, 3)                  // ㅂㅐ열

    for (arr in array)
        println(arr)

    var perfectSquares = Array(10, { k -> k * k }) // 함수로부터 배열 생성
    for (k in perfectSquares)
        println(k)

    println(array.size)
}

fun plusOne(x: Int) = x + 1

