package main.scala.exercises

import scala.collection.mutable.ArrayBuffer

object ch06_objects_q5 extends App {
  //Q5 Write a Scala application, using the App trait, that prints its command-line
  //arguments in reverse order, separated by spaces. For example, scala Reverse
  //Hello World should print World Hello.
  for (a <- args.reverse) print(s"$a ")

}
