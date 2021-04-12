package main.scala.chapters

import scala.collection.mutable.ArrayBuffer

object ch03 extends App {

  // fixed-length arrays
  val nums = new Array[Int](10) // empty array of 10
  val a = Array(1,2,3,4,5) // note no new keyword

  // variable-length arrays
  val b = ArrayBuffer[Int]()
  b += 1
  b += (4,3,2,1)
  println(b)

  // traverse array
  for (i <- 0 until b.length)
    println(s"$i: ${b(i)}")

  println("Going backwards...")
  for (i <- b.length - 1 until -1 by -1){
    println(s"$i: ${b(i)}")
  }

  println("Access elements directly...")
  for (el <- b){
    println(el)
  }

  // transforming arrays
  val arr = Array(2,3,5,7,11)
  val result = for (elem <- arr) yield 2 * elem
  println(result.mkString(","))

  // remove all negative numbers? use for-yield combo also
  val arr2 = ArrayBuffer.range(1,11)
  val result2 = for (elem <- arr2 if elem % 2 == 0) yield elem
  println(result2.mkString(","))

  // common algorithms
  println(arr2.max)
  println(arr2.min)
  println(arr2.sum)

  // multi-dimensional arrays
  val matrix= Array.ofDim[Double](3,4) // 3R x 4C



}
