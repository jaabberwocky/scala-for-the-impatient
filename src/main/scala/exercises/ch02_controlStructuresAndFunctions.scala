package main.scala.exercises

import scala.annotation.tailrec

object ch02_controlStructuresAndFunctions extends App {

  // Q1. Write signum function
  def signum(x: Int): Int = {
    if (x > 0) 1
    else if (x < 0) -1
    else 0
  }

  // Q2. Value of an empty block expression and type?
  // In REPL: val x = {}
  // val x: Unit = ()

  // Q3. Come up with a situation where the assignment
  // x = y = 1 is valid in Scala

  // Q4. Write Scala loop for equivalent
  // Java loop: for (int i = 10; i >= 0; i--) System.out.println(i);
  for (i <- 10 to 0 by -1) {
    println(i)
  }

  // Q5. Write a procedure countdown that prints
  // numbers from n to 0
  def countdown(n: Int): Unit = {
    var ctr = n
    while (ctr >= 0) {
      println(ctr)
      ctr -= 1
    }
  }

  countdown(10)

  // Q6. Write a for loop for computing the product of the
  // Unicode codes of all letters in a string
  def computeUnicodeSum(s: String) = {
    var accum: Long = 1
    for (ch <- s) {
      accum *= ch.toInt
    }
    accum
  }

  println(computeUnicodeSum("Hello"))

  // Q7. Solve preceding exercise without writing a loop
  def noLoopComputeUnicodeSum(s: String) = {
    var accum: Long = 1
    s.foreach(accum *= _)
    accum
  }

  println(noLoopComputeUnicodeSum("Hello"))

  // Q8. Write a function (already done above)

  // Q9. Make the function a recursive function
  def recursiveComputeUnicodeSum(s: String): Long = {
    val startingAccum = 1

    @tailrec
    def funcHelper(accum: Long, s: String): Long = {
      if (s.length == 1) accum * s.charAt(0).toInt
      else {
        funcHelper(accum * s.charAt(0).toInt, s.substring(1, s.length))
      }
    }

    funcHelper(startingAccum, s)
  }

  println(recursiveComputeUnicodeSum("Hello"))

  // Q10.

  // Using if/else:
  def power1(x: Double, n: Int): Double =
    if (n == 0) 1
    else if (n < 0) 1 / power1(x, -n)
    else if (n % 2 == 0 && n > 2) power1(power1(x, n / 2), 2)
    else x * power1(x, n - 1)
}

