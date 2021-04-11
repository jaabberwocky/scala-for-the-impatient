import scala.math.BigInt.probablePrime // answer to Q7
import scala.util.Random // answer to Q7

object ch01_basics extends App {

  // Q1. Scala REPL 3 followed by tab has 196 combinations remaining.

  // Q2. SquareRoot of 3 difference with 3.
  val x = 3
  println(s"Difference of 3 and sqrt(3) is ${x - scala.math.pow(3, 0.5)}")

  // Q3. Res values are val (immutable)

  // Q4. Multiply a string 3 times
  val s = "crazy"
  println(s * 3)

  // Q5. 10 max 2
  // max is a method of the Int class
  println(s"Output of 10 max 2: ${10 max 2}")

  // Q6. Use BigInt to compute to 2 to power of 1024
  val b: BigInt = BigInt(2).pow(1024)
  println(b)

  // Q7. What do you need to import so that you can get a random prime as
  // probablePrime(100, Random) without any qualifiers?
  val p: BigInt = probablePrime(100, Random)
  println(s"probablePrime(100, Random) = $p")

  // Q8. Produce a random BigInt and convert it to base 36
  val r: BigInt = BigInt(100, rnd = Random)
  println(s"Random BigInt ($r) with base 36 (${r.toString(36)})")

  // Q9. Get first character of string
  val myString = "Hello world"
  println(s"First char: ${myString.charAt(0)}")
  println(s"Last char: ${myString.last}")

  // Q10. What do take, drop, takeRight and dropRight string functions do?
  // What advantage do they have over using substring?
  println(myString.take(4)) // selects the first n items
  println(myString.drop(4)) // selects all BUT the first n items
  println(myString.takeRight(4)) // selects the last n items
  println(myString.dropRight(4)) // selects ALL but the last n items

  println(myString.substring(4, myString.length)) // it is harder to use because you have to input the length of the string


}
