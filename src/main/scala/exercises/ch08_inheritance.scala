package main.scala.exercises
/*
*/
import scala.collection.mutable.ArrayBuffer

object ch08_inheritance extends App {
  //Q1 Extend the following BankAccount class to a CheckingAccount class that charges $1
  //for every deposit and withdrawal.
  //class BankAccount(initialBalance: Double) {
  //private var balance = initialBalance
  //def currentBalance = balance
  //def deposit(amount: Double) = { balance += amount; balance }
  //def withdraw(amount: Double) = { balance -= amount; balance }
  //}

  class BankAccount(initialBalance: Double) {
    private[this] var balance = initialBalance
    def currentBalance: Double = balance
    def deposit(amount: Double): Double = { balance += amount; balance }
    def withdraw(amount: Double): Double = { balance -= amount; balance }
  }

  class CheckingAccount(initialBalance: Double, charges: Double = 1.0) extends BankAccount(initialBalance: Double) {

    override def deposit(amount: Double): Double = {super.deposit(amount - charges)}
    override def withdraw(amount: Double): Double = {super.withdraw(amount - charges)}
  }

  //Q2 Extend the BankAccount class of the preceding exercise into a class SavingsAccount
  //that earns interest every month (when a method earnMonthlyInterest is called)
  //and has three free deposits or withdrawals every month. Reset the transaction
  //count in the earnMonthlyInterest method.

  class SavingsAccount(initialBalance: Double, charges: Double = 1.0, val interest: Double) extends BankAccount(initialBalance) {
    private[this] var transactionCount = 0

    override def deposit(amount: Double): Double = {
      if (transactionCount <= 3) {
        transactionCount += 1
        super.deposit(amount)
      } else {transactionCount += 1; super.deposit(amount - charges)}
    }

    override def withdraw(amount: Double): Double = {
      if (transactionCount <= 3) {
        transactionCount += 1
        super.withdraw(amount)
      } else {transactionCount += 1; super.deposit(amount - charges)}
    }

    def earnMonthlyInterest: Double = {
      transactionCount = 0
      super.deposit(super.currentBalance * interest)
    }

  }

  //Q3 Consult your favorite Java or C++ textbook which is sure to have an example
  //of a toy inheritance hierarchy, perhaps involving employees, pets, graphical
  //shapes, or the like. Implement the example in Scala.

  //Note: Implementing this example -> https://howtodoinjava.com/java/oops/java-inheritance/

  class Employee(val id: Long, val firstName: String, val lastName: String) {
    override def toString: String = s"Employee: {id=$id, firstName=$firstName, lastName=$lastName}"
  }

  class Manager(id: Long, firstName:String, lastName:String) extends Employee(id,firstName,lastName) {
    private val directReports = new ArrayBuffer[Employee]()

    def getDirectReports: String = directReports.mkString(" | ")

    def addDirectReports(e: Employee*): Unit = {
      // takes in variable args
      for (emp <- e) {
        directReports += emp
      }
    }

  }
  val John = new Employee(1, "John", "Doe")
  val Peter = new Employee(2, "Peter", "Pan")
  val Mary = new Employee(3, "Mary", "Phillips")
  val Tom = new Manager(4, "Tom", "Bossman")

  Tom.addDirectReports(John)
  Tom.addDirectReports(Peter, Mary)
  println(Tom.getDirectReports)
  println(Tom)
}
