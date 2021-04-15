package main.scala.exercises

import java.beans.BeanProperty

object ch05_classes extends App {

  //Q1 Improve the Counter class in Section 5.1, “Simple Classes and Parameterless
  //Methods,” on page 55 so that it doesn't turn negative at Int.MaxValue.
  class Counter {
    private var value = 0

    def increment(): Unit = {
      if (value < Int.MaxValue) value += 1
    }
    def current() = this.value
  }

  //Q2 Write a class BankAccount with methods deposit and withdraw, and a read-only
  //property balance.

  class BankAccount {
    private var _balance = 0

    def balance = _balance

    def deposit(amount: Int): Unit = _balance += amount

    def withdraw(amount: Int) =
      if (amount > _balance) throw new IllegalArgumentException("You don't have enough cash!")
      else _balance -= amount
  }

  val b = new BankAccount()
  b.deposit(1000)
  b.withdraw(500)
  println(b.balance)

  //Q3 Write a class Time with read-only properties hours and minutes and a method
  //before(other: Time): Boolean that checks whether this time comes before the
  //other. A Time object should be constructed as new Time(hrs, min), where hrs is in
  //military time format (between 0 and 23).

  class Time(val hrs: Int, val min: Int) {
    require(hrs >= 0 && hrs <= 23)
    require(min >= 0 && hrs <= 60)

    def before(other: Time): Boolean = {
      if (this.hrs < other.hrs) return true
      else if (this.hrs == other.hrs)
        if (this.min < other.min) return true
      false
    }

    override def toString = s"Time($hrs:$min)"
  }

  val t1 = new Time(23, 0)
  val t2 = new Time(14, 30)
  println(s"t1: ${t1}\nt2: ${t2}")
  println(t2 before t1)

  //Q4 Reimplement the Time class from the preceding exercise so that the internal
  //representation is the number of minutes since midnight (between 0 and 24 ×
  //60 – 1). Do not change the public interface. That is, client code should be
  //unaffected by your change.

  class Time2(val hrs: Int, val min: Int) {
    require(hrs >= 0 && hrs <= 23)
    require(min >= 0 && hrs <= 60)
    val minAfterMidnight = (hrs * 60) + min - 1

    def before(other: Time2): Boolean = {
      if (this.minAfterMidnight < other.minAfterMidnight) return true
      false
    }

    override def toString = s"Time($hrs:$min)"
  }
  val t3 = new Time2(23, 0)
  val t4 = new Time2(14, 30)
  println(s"t3: ${t3}\nt4: ${t4}")
  println(t4 before t3)

  //Q5 Make a class Student with read-write JavaBeans properties name (of type String)
  //and id (of type Long). What methods are generated? (Use javap to check.) Can
  //you call the JavaBeans getters and setters in Scala? Should you?

  // javap output
  //Compiled from "ch05_classes.scala"
  //public class main.scala.exercises.ch05_classes$Student {
  //  public java.lang.String name();
  //  public void name_$eq(java.lang.String);
  //  public long id();
  //  public void id_$eq(long);
  //  public long getId();
  //  public java.lang.String getName();
  //  public void setId(long);
  //  public void setName(java.lang.String);
  //  public main.scala.exercises.ch05_classes$Student();
  //}

  class Student {
    @BeanProperty var name: String = _
    @BeanProperty var id: Long = _
  }

  val s1 = new Student
  s1.setName("John")
  s1.setId(458)

  //Q6 In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,”
  //on page 55, provide a primary constructor that turns negative ages to 0.
  class Person(private var age: Int) {
    if (age < 0) age = 0

    def getAge(): Int = this.age

    def setAge(inputAge: Int): Unit = {
      if (inputAge < 0) this.age = 0
      else this.age = inputAge
    }

  }

  val p1 = new Person(-4)
  p1.setAge(45)
  p1.setAge(-11)
  println(p1.getAge())

  //Q7 Write a class Person with a primary constructor that accepts a string containing
  //a first name, a space, and a last name, such as new Person("Fred Smith"). Supply
  //read-only properties firstName and lastName. Should the primary constructor
  //parameter be a var, a val, or a plain parameter? Why?
  class Person2(name: String) {
    private val nameWords = name.split(" ")
    val firstName = nameWords(0)
    val lastName = nameWords(1)
  }

  val p2 = new Person2("John Smith")
  println(p2.firstName)
  println(p2.lastName)

  //Q8 Make a class Car with read-only properties for manufacturer, model name,
  //and model year, and a read-write property for the license plate. Supply four
  //constructors. All require the manufacturer and model name. Optionally,
  //model year and license plate can also be specified in the constructor. If not,
  //the model year is set to -1 and the license plate to the empty string. Which
  //constructor are you choosing as the primary constructor? Why?

  class Car(val manufacturer: String, val modelName: String, val modelYear: Int, var licensePlate: String) {

    def this(manufacturer: String, modelName: String, modelYear: Int) =
      this(manufacturer, modelName, modelYear, "")

    def this(manufacturer: String, modelName: String, licensePlate: String) =
      this(manufacturer, modelName, -1, licensePlate)

    def this(manufacturer: String, modelName: String) =
      this(manufacturer, modelName, -1, "")
  }

  //Q10 Consider the class
  //class Employee(val name: String, var salary: Double) {
  //def this() { this("John Q. Public", 0.0) }
  //}
  //Rewrite it to use explicit fields and a default primary constructor. Which form
  //do you prefer? Why?

  class Employee(val name: String = "John Q. Public", val salary: Double = 0.0) {

  }

}
