package main.scala.chapters

object ch04 extends App {

  // construct a map
  // this is immutable
  val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
  val scores2 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8)) // equivalent

  // mutable map
  val mutableScores = scala.collection.mutable.Map("John" -> 4, "James" -> 5, "Peter" -> -1)
  mutableScores("John") = 9
  println(mutableScores)

  // accessing map values
  println(mutableScores("John"))

  // check for membership
  println(s"Is there a key with value Shawn? ${mutableScores.contains("Shawn")}")



}
