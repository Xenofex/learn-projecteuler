package projecteuler

import projecteuler.util._
import scala.math._

object Problem29 {
  
  val maxB = 5

  def intPowGreaterThan(n: Int, p: Int, v: Int) = {
    def recurse(i: Int, r: Int): Boolean = 
      if (r > v) true
      else if (i >= p) false
      else recurse(i + 1, r * n)

    recurse(1, n)
  }
  
  def main(args: Array[String]) {
    val matrix = Array.fill[Boolean](maxB + 1, maxB + 1)(true)
    for {
      a <- 2 to sqrt(maxB).toInt
      b <- 2 to maxB
      if matrix(a)(b) == true
      d <- divisorsOf(b).tail
      if !intPowGreaterThan(a, d, maxB)
    } {
      println(a + "\t" + b + "\t" + d)
      matrix(intPow(a, d))(b / d) = false
    }

    var sum = 0
    for (a <- 2 to maxB; b <- 2 to maxB; if matrix(a)(b) == true)
      sum += 1

    println("Result of problem 29: " + sum)
  }

}
