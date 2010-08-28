package projecteuler

import Util._

object Problem40 {
  
  var i = 0
  var j = 0

  val partitions = Array.fill(7) {
    i += 1
    j += 9 * intPow(10, i - 1) * i
    j
  }

  def paddingZeroes(n: Int) = {
    val size = partitions.size
    def find(n: Int, i: Int): Int =
      if (i >= size - 2)
        size
      else if (partitions(i) < n && partitions(i + 1) >= n)
        i
      else
        find(n, i + 1)

    find(n, 0) + 1
  }

  def d(n: Int) = {
    val padding = paddingZeroes(n)
    var shifted = n
    for (i <- 1 to padding)
      shifted += intPow(10, i) - 1
    val division = shifted / (padding + 1)
    val mod = shifted % (padding + 1)
    if (mod == 0)
      division % 10
    else
      digitsOf(division + 1)(mod - 1)
  }

  def main(args: Array[String]) {
    var prod = 1
    for (i <- 0 to 6)
      prod *= d(intPow(10, i))

    println(prod)
  }

}
