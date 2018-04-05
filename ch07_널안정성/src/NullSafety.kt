class Personfour(name: String, val address: Address?)
class Address(name: String, postcode: String, val city: City?)
class City(name: String, val country: Country?)
class Country(val name: String)

fun getCountryName(person: Personfour?): String? { //똑똑한 형변환 이용한 널 처리
  var conutryName: String? = null
  if(person != null) {
    val address = person.address
    if(address != null) {
      val city = address.city
      if(city != null) {
        val country = city.country
        if(country != null) {
          conutryName = country.name
        }
      }
    }
  }

  return conutryName
}

fun getCountryNameTwo(person: Personfour?):String? { // 안전한 널 접근
  return person?.address?.city?.country?.name
}

fun nullableList(){         // 널 허용 가능한 컬렉션
  val nullableList: List<Int?> = listOf(1,2,null,4)
  val intList: List<Int> = nullableList.filterNotNull()

  intList.forEach{
    println(it)
  }
}

fun main(args: Array<String>) {
  val country = Country("byeongsoon")
  val city = City("daejeon",country)
  val address = Address("yusung","1111",city)
  val personfour = Personfour("jang",address)

  println(getCountryName(personfour))
  println(getCountryNameTwo(personfour))

  val nullableName: String? = "jang" // 널이 허용 안되는 값에 널이 허용 가능한 값을 강제로 넣을 때 !! 사용
  val name: String = nullableName!!

  val nullableNameTwo: String? = null // 엘비스 연산자
  val nameTwo: String = nullableNameTwo ?: "default name"

  println(nameTwo)

  val location: Any = "London" // 안전한 형변환
  val safeString: String? = location as? String
  val safeInt: Int? = location as? Int

  println(safeString)
  println(safeInt)

  val stringTest: String? = "jang"  // 똑똑한 형변환
  if (stringTest != null){
    println(stringTest.length)
  }

  nullableList()

}