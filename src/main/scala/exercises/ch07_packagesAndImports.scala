package main.scala.exercises.ch07

import java.util

//Q2 Write a puzzler that baffles your Scala friends, using a package com that isn’t at the top level.
package puzzler.scala.com {
}

//Q3 Write a package random with functions nextInt(): Int, nextDouble(): Double,
//and setSeed(seed: Int): Unit.

package object Random {
  private val a = 1664525
  private val b = 1013904223
  private val n = 32
  private var previous = 0

  def setSeed(seed: Int) = {
    this.previous = seed
  }

  def nextInt(): Int = {
    val next = (previous * a + b) % scala.math.pow(2,n).toInt
    previous = next
    next
  }

  def nextDouble(): Double = {
    nextInt()
  }
}

//Q4 Why do you think the Scala language designers provided the package object
//syntax instead of simply letting you add functions and variables to a package?

//ans: Namespace to prevent conflict and enable re-use

//Q5: What is the meaning of private[com] def giveRaise(rate: Double)? Is it useful?

//ans: This is private to the com package level only. Yes, prevents conflict.

//Q6: Write a program that copies all elements from a Java hash map into a Scala
//hash map. Use imports to rename both classes.
package object HashMapConverter {
  import java.util.{HashMap => JHashMap}
  import scala.collection.mutable.{HashMap => SHashMap}

  def convertToScalaMap[K,V](jmap: JHashMap[K, V]): SHashMap[K, V] = {
    var smap = new SHashMap[K, V]()
    var it = jmap.entrySet().iterator()

    while (it.hasNext) {
      val pair = it.next()
      smap(pair.getKey) = pair.getValue
    }
    smap
  }
}

//Q8 What is the effect of
//import java._
//import javax._
//Is this a good idea?

//ans: Imports everything from java top level package into namespace. Not a good idea.

//Q9 Write a program that imports the java.lang.System class, reads the user name
//from the user.name system property, reads a password from the StdIn object,
//and prints a message to the standard error stream if the password is not
//"secret". Otherwise, print a greeting to the standard output stream. Do not
//use any other imports, and do not use any qualified names (with dots).

package object SystemPassword {
  private val password = "secret"
  private val username = getUserName()

  private def getUserName(): String = {
    import java.lang.System._
    getProperty("user.name")
  }

  def enterPassword() = {
    print("Enter your password: ")
    val s: String = scala.io.StdIn.readLine()
    if (s == password) {
      println(s"Hello ${username}!")
    } else println("Wrong password!")
  }
}

// Q10 Apart from StringBuilder, what other members of java.lang does the scala package override?

//ans: Many. HashMap, ArrayBuffer etc

object ch07_test extends App {
  val value1 = Random.nextInt()


  val jmap = new util.HashMap[String, Int]()
  jmap.put("Hello", 1)
  jmap.put("World", 2)

  val s = HashMapConverter.convertToScalaMap(jmap)
  println(s"Java map: $jmap")
  println(s"Scala map: $s")

  SystemPassword.enterPassword()
}

