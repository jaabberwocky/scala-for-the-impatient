package main.scala.chapters

import java.beans.BeanProperty

object ch05 extends App {

  class Counter {
    private var value = 0

    def increment() {this.value += 1}
    def current() = this.value
  }

  val c = new Counter()
  c.increment
  println(c.current())

  // automatic getters and setters
  class Person {
    var age = 0
  }

  val p = new Person()
  p.age = 24
  println(p.age)

  class Person2 {
    var privateAge = 0

    def age = privateAge
    def age_= (newValue: Int): Unit = { // this is the synth setter
      if (newValue > privateAge) {
        privateAge = newValue
      }
    }
  }

  val p2 = new Person2
  println(p2.age)
  p2.age = 45
  p2.age = 23
  println(p2.age)

  // properties with only getters
  class Person3 {
    val age = 0
  }

  val p3 = new Person3
  // p3.age = 45 // not possible
  println(p3.age)

  // bean properties
  // defines getProp() setProp()

  class Person4 {
    @BeanProperty var age: Int = 0
  }

  val p4 = new Person4
  p4.setAge(88)
  println(p4.getAge())


  // primary constructors
  class Vehicle(val vehicleName: String, val vehicleType: String, val numWheels: Int) {

  }

  val v1 = new Vehicle("Johnson", "VW Beetle", 4)


}
