package projecteuler

import projecteuler.util._
import scala.collection.mutable.ListBuffer

object Problem35 {
  
  def getCirculars(digits: Array[Int]) = {
    val numOfDigits = digits.length
    val circulars = new ListBuffer[Int]
    var num, j = 0
    for (i <- 0 to numOfDigits - 1) {
      num = 0
      j = numOfDigits - 1
      for (k <- i to numOfDigits - 1) {
        num += intPow(10, j) * digits(k)
        j -= 1
      }
      for (k <- 0 to i - 1) {
        num += intPow(10, j) * digits(k)
        j -= 1
      }
      
      circulars += num
    }

    circulars.toSet
  }

  def main(args: Array[String]) {
    val primes = new Prime(1000000).all.toSet

    val circularPrimes = for {
      p <- primes
      d = digitsOf(p)
      if d.size == 1 || !d.contains(2) && !d.contains(4) && !d.contains(5) && !d.contains(6) && !d.contains(8) && !d.contains(0)
      c = getCirculars(d)
      if c.subsetOf(primes)
    } yield p

    println(circularPrimes.size)
  }

}
