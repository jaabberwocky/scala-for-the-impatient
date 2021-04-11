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


}
