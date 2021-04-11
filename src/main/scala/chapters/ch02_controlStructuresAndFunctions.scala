package main.scala.chapters

import scala.io.StdIn

object ch02_controlStructuresAndFunctions extends App {

  // ask for input
  def printUserName(): Unit = {
    val name = StdIn.readLine("Your name is: ")
    print("Your age: ")
    val age = StdIn.readInt()
    println(s"Hello $name! You are $age years old today.")
  }

  // printUserName()

  // while loop
  println("While loop")
  var n = 0
  while (n < 10) {
    println(n)
    n += 1
  }

  // for loop
  println("For loop")
  for (i <- 1 to 10) {
    println(i)
  }

  // throw exceptions
  def getSquareRoot(x: Int) = {
    if (x >= 0) {
      scala.math.pow(x, 0.5)
    } else throw new IllegalArgumentException("x cannot be negative")
  }

  println(getSquareRoot(0))



}

