package projecteuler

import util._

object Problem52 {

  def findSmallest(n: Int): Int = {
    val digits = digitsOf(n).toSet

    if (digits == digitsOf(n * 2).toSet &&
        digits == digitsOf(n * 3).toSet &&
        digits == digitsOf(n * 4).toSet &&
        digits == digitsOf(n * 5).toSet &&
        digits == digitsOf(n * 6).toSet)
      n
    else
      findSmallest(n + 1)
  }

  def main(args: Array[String]) {
    println(findSmallest(1))
  }

}
