import kotlin.reflect.KProperty

open class WithInheritance {
  open var isAvailable: Boolean = true
  get() = field
  protected set(value) {
    field = value
  }
}

class WithInheritanceDerived(isAvailable: Boolean): WithInheritance() {
  override var isAvailable: Boolean = isAvailable
    get() {
      return super.isAvailable
    }
    set(value) {
      println("WithInhertianceDerived.isAvailable")
      field = value
    }

  fun doSomething() {
    println("doSomething")
    isAvailable = false
    println("end")
  }
}

class WithLazyProperty {
  val foo: Int by lazy {
    println("Initializing foo")
    2
  }
}

fun main(args: Array<String>) {
  val withInheritance = WithInheritanceDerived(false)
  withInheritance.doSomething()
  println("withInheritance:${withInheritance.isAvailable}")

  val measure = Measure()
  measure.writeTimestamp = System.currentTimeMillis()
  println("Current measure taken at: ${measure.writeTimestamp}")

  //println("${Measure::writeTimestamp}")
  val withLazyProperty = WithLazyProperty()
  val total = withLazyProperty.foo + withLazyProperty.foo
  println("Lazy property total:$total")

}

class Test{
  lateinit var name: String
  lateinit var address: String
  var test: String = ""

  fun initProperty(test: String){
    this.test = test
  }
}
class TimestampValueDelegate {
  private var timestamp = 0L
  operator fun getValue(ref: Any?, property: KProperty<*>): Long {
    return timestamp
  }

  operator fun setValue(ref: Any?, property: KProperty<*>, value: Long) {
    timestamp = value
  }
}

class Measure {
  var writeTimestamp: Long by TimestampValueDelegate()
}
