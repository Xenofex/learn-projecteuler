package projecteuler

import projecteuler.util._

object Problem36 {

  def main(args: Array[String]) {
    var sum = 0
    for {
      i <- 1 to 1000000
      if isPalindromic(i) && isBinaryPalindromic(i)
    } sum += i

    println(sum)
  }

}
