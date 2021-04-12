package main.scala.exercises

import scala.collection.mutable.ArrayBuffer

object ch03_workingWithArrays extends App {

  // Q1 Write a code snippet that sets a to an array of n random integers
  // between 0 (inclusive) and n (exclusive)

  def generateRandomArray(n: Int): Array[Int] = {
    val arr = new Array[Int](n)
    val r = scala.util.Random
    r.setSeed(System.currentTimeMillis)

    for (i <- arr.indices) {
      arr(i) = r.nextInt(n)
    }
    arr
  }

  println(generateRandomArray(45).mkString(","))

  // Q2 Write a loop that swaps adjacent elements of an array
  // of integers.

  def swapAdjacent[T](arr: Array[T]): Array[T] = {
    for (i <- 0 until arr.length - 1 by 2) {
      val tmp = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = tmp
    }
    arr
  }

  val arr2 = Array.range(1, 10)
  println(swapAdjacent(arr2).mkString(","))

  // Q3. Use a for/yield for above instead

  def swapAdjacentForYield[T](arr: Array[T]): Array[T] = {
    for (i <- 1 until arr.length + 1 by 2;
      j <- (i - 1 to i reverse) if j < arr.length)
      yield j
    arr
  }
  println(swapAdjacentForYield(arr2).mkString(","))

  // Q4 Given an array of integers, produce a new array that contains all positive values of the original array,
  // in their original order,
  // followed by all values that are zero or negative, in their original order.

  def positiveThenNegative(arr: Array[Int]): Array[Int] = {
    val posArr = arr.filter(_ > 0)
    val negArr = arr.filter(_ <= 0)

    posArr ++ negArr // concatenates array
  }
  val arr3 = Array(0,1,3,4,5,-6,1,2,-45)
  println(positiveThenNegative(arr3).mkString(","))

  // Q5 How do you compute the average of an Array[Double]?

  def calcAverage(arr: Array[Double]): Double = {
    val total = arr.sum
    arr.sum / arr.length
  }

  val arr4 = Array(1.0,2.0,3.0,4.0,5.0,9.0)
  println(calcAverage(arr4))

  // Q6 How do you rearrange the elements of an Array[Int] so that they appear in
  // reverse sorted order?
  def reverseSorted(arr: Array[Int]): Array[Int] = {
    scala.util.Sorting.quickSort(arr)
    arr.reverse
  }

  def reverseSorted(arr: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    // note: not in place
    val ar = arr.sorted
    ar.reverse
  }

  println(reverseSorted(Array(1,4,5,8,1,0,4)).mkString(","))
  println(reverseSorted(ArrayBuffer(1,4,5,8,1,0,4)).mkString(","))

  // Q7 Write a code snippet that produces all values from an array with duplicates removed.
  def removeDuplicates[T](arr: Array[T]): Array[T] = {
    arr.distinct
  }

  println(removeDuplicates(Array("hello","hello","world")).mkString(","))

  // Q8 Refactor code to be more efficient

  def removeAllButFirstNegative(arr: ArrayBuffer[Int]): Unit = {
    val posRemove = for (i <- 0 until arr.length if arr(i) < 0) yield i
    posRemove.drop(1)

    for (i <- posRemove.drop(1).reverse) {
      arr.remove(i)
    }
  }

  val arr5 = ArrayBuffer[Int](-1,-1,0,3,-4,5,6)
  removeAllButFirstNegative(arr5)
  println(arr5.mkString(","))
}

