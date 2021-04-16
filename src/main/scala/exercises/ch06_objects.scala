package main.scala.exercises

object ch06_objects extends App {

  //Q1 Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and
  //milesToKilometers.

  object Conversions {
    def inchesToCentimeters(in: Double): Double = in * 2.54
    def gallonsToLiters(gal: Double): Double = gal * 3.78541
    def milesToKilometers(mi: Double): Double = mi * 1.60934
  }

  //Q2 The preceding problem wasn’t very object-oriented. Provide a general superclass
  //UnitConversion and define objects InchesToCentimeters, GallonsToLiters, and
  //MilesToKilometers that extend it.
  abstract class UnitConversion {
    def convert(in: Double): Double
  }

  object InchesToCentimeters extends UnitConversion {
    override def convert(in: Double): Double = in * 2.54
  }

  object GallonsToLiters extends UnitConversion {
    override def convert(in: Double): Double = in * 3.78541
  }

  object MilesToKilometers extends UnitConversion {
    override def convert(in: Double): Double = in * 1.60934
  }

  //Q3 Define an Origin object that extends java.awt.Point. Why is this not actually a
  //good idea? (Have a close look at the methods of the Point class.)


  //Q4 Define a Point class with a companion object so that you can construct Point
  //instances as Point(3, 4), without using new.
  class Point private (private val x: Int, private val y: Int) {
    override def toString: String = s"Point {$x,$y}"
  }

  object Point {
    def apply(x: Int, y:Int) =
      new Point(x, y)
  }

  val p = Point(1,4)
  println(p)

  //Q5 Write a Scala application, using the App trait, that prints its command-line
  //arguments in reverse order, separated by spaces. For example, scala Reverse
  //Hello World should print World Hello.

  //Done in ch06_objects_q5

  //Q6 Write an enumeration describing the four playing card suits so that the toString
  //method returns ß, ®, ©, or ™.

  println(PlayingCardSuits.Spade)

  object PlayingCardSuits extends Enumeration {
    type PlayingCardSuits = Value
    val Spade = Value("\u2660")
    val Diamond = Value("\u2666")
    val Club = Value("\u2663")
    val Heart = Value("\u2764")
  }



  //Q7 Implement a function that checks whether a card suit value from the preceding
  //exercise is red.
  import PlayingCardSuits._
  def isRed(suit: PlayingCardSuits): Boolean =
    suit == Diamond || suit == Heart

  //Q8 Write an enumeration describing the eight corners of the RGB color cube.
  // As IDs, use the color values (for example, 0xff0000 for Red).
  object RGBColors extends Enumeration {
    type RGBColors = Value
    val Black = Value(0x000000)
    val White = Value(0xffffff)
    val Red = Value(0xff0000)
    val Green = Value(0x00ff00)
    val Blue = Value(0x0000ff)
    val Yellow = Value(0xffff00)
    val Cyan = Value(0x00ffff)
    val Magenta = Value(0xff00ff)
  }

  println(RGBColors.Red)

}
