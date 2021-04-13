package main.scala.exercises

import java.util.Scanner
import scala.collection.JavaConverters._
import scala.collection.mutable
import java.util.Calendar._

object ch04_mapsAndTuples extends App {

    // Q1 Set up a map of prices for a number of gizmos that you covet. Then produce
    // a second map with the same keys and the prices at a 10 percent discount.
    val gizmos = Map("iPhone" -> 1299, "S21" -> 800, "Pixel" -> 999)
    val gizmosDiscounted = for ((k,v) <- gizmos) yield (k, v * 0.90)
    println(gizmosDiscounted)

  //Q2 Write a program that reads words from a file. Use a mutable map to count
  //how often each word appears. To read the words, simply use a java.util.Scanner:
  //val in = new java.util.Scanner(new java.io.File("myfile.txt"))
  //while (in.hasNext()) process in.next()
  //Or look at Chapter 9 for a Scalaesque way.
  //At the end, print out all words and their counts.

  def getWordCounts(file: String): mutable.Map[String, Int] = {
    val wordCounts = scala.collection.mutable.Map[String, Int]()

    val in = new java.util.Scanner(new java.io.File(file))
    while (in.hasNext()) {
      val words: Array[String] = in.nextLine().split(" ")
      for (elem <- words) {
        val word = elem.toLowerCase
          .replace(",", "")
          .replace(",", "")
          .replace(".", "")
          .replace("\"", "")
          .replace("'", "")
        if (wordCounts contains word) wordCounts(word) += 1
        else wordCounts(word) = 1
      }
    }
  wordCounts
  }

  val wc = getWordCounts("resources/myfile.txt")
  println(wc)

  //Q3 Repeat the preceding exercise with an immutable map.

  def getWordCountsImmutable(file: String): Map[String, Int] = {
    var wordCounts = Map[String, Int]()

    val in: Scanner = new java.util.Scanner(new java.io.File(file))
    while (in.hasNext()) {
      val words: Array[String] = in.nextLine().split(" ")
      for (elem <- words) {
        val word = elem.toLowerCase
          .replace(",", "")
          .replace(",", "")
          .replace(".", "")
          .replace("\"", "")
          .replace("'", "")
        if (wordCounts contains word) {
          val tmp: Int = wordCounts(word) + 1 // increment count
          wordCounts += (word -> tmp)
        } else wordCounts += (word -> 1)
      }
    }
    wordCounts
  }
  val wc2 = getWordCountsImmutable("resources/myfile.txt")
  println(wc2)

  println(s"Are the keys the same?: ${wc.equals(wc2)}")

  //Q4 Repeat the preceding exercise with a sorted map, so that the words are
  //printed in sorted order.

  def getWordCountsSortedMap(file: String): mutable.Map[String, Int] = {
    val wordCounts = scala.collection.mutable.SortedMap[String, Int]()

    val in: Scanner = new java.util.Scanner(new java.io.File(file))
    while (in.hasNext()) {
      val words: Array[String] = in.nextLine().split(" ")
      for (elem <- words) {
        val word = elem.toLowerCase
          .replace(",", "")
          .replace(",", "")
          .replace(".", "")
          .replace("\"", "")
          .replace("'", "")
        if (wordCounts contains word) {
          wordCounts(word) += 1
        } else wordCounts(word) = 1
      }
    }
    wordCounts
  }

  val wc3 = getWordCountsSortedMap("resources/myfile.txt")
  println(wc3)

  //Q5 Repeat the preceding exercise with a java.util.TreeMap that you adapt to the
  //Scala API.
  def getWordCountsJavaMap(file: String) = {
    val wordCounts: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int].asScala

    val in: Scanner = new java.util.Scanner(new java.io.File(file))
    while (in.hasNext()) {
      val words: Array[String] = in.nextLine().split(" ")
      for (elem <- words) {
        val word = elem.toLowerCase
          .replace(",", "")
          .replace(",", "")
          .replace(".", "")
          .replace("\"", "")
          .replace("'", "")
        if (wordCounts contains word) {
          wordCounts(word) += 1
        } else wordCounts(word) = 1
      }
    }
    wordCounts
  }

  val wc4 = getWordCountsSortedMap("resources/myfile.txt")
  println(wc4)
  println(s"Is this same as native Scala SortedMap?: ${wc3.equals(wc4)}")

  //Q6 Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and
  //similarly for the other weekdays. Demonstrate that the elements are visited
  //in insertion order.

  def generateWeekdayLinkedHashMap(): mutable.Map[String, Int] = {
    val weekdayMap = scala.collection.mutable.LinkedHashMap[String, Int]()

    weekdayMap("Monday") = MONDAY
    weekdayMap("Tuesday") = TUESDAY
    weekdayMap("Wednesday") = WEDNESDAY
    weekdayMap("Thursday") = THURSDAY
    weekdayMap("Friday") = FRIDAY

    weekdayMap
  }

  val wdm = generateWeekdayLinkedHashMap()
  println(wdm)

  //Q7 Print a table of all Java properties reported by the getProperties method of the
  //java.lang.System class, like this

  def printJavaPropertiesTable(): Unit = {
    val prop = java.lang.System.getProperties.asScala
    var maxKey = ""

    // find longest key
    for ((k,v) <- prop) {
      if (k.length > maxKey.length) maxKey = k
    }

    // using string interpolation to right pad
    for ((k,v) <- prop) {
      println(s"%-${maxKey.length + 1}s| %s" format(k, v take 40))
    }

  }

  printJavaPropertiesTable()

  //Q8 Write a function minmax(values: Array[Int]) that returns a pair containing the
  //smallest and the largest values in the array.

  def minmax(values: Array[Int]): (Int, Int) = {
    (values.min, values.max)
  }

  val arr1 = Array(1,2,3,4)
  println(minmax(arr1))

  //Q9 Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing
  //the counts of values less than v, equal to v, and greater than v.

  def lteggt(values: Array[Int], v: Int): (Int, Int, Int) ={
    val lte = values.filter(_ < v)
    val eq = values.filter(_ == v)
    val gte = values.filter(_ > v)

    (lte.length, eq.length, gte.length)
  }

  val arr2 = Array(1,1,2,2,3,3,4,4)
  println(lteggt(arr2, 3)) // (4,2,2)

  println("Hello".zip("World"))
}
