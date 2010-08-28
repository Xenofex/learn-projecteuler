package projecteuler

import scala.math._

object Util {
  
  def factorial(n: Int): Int = {
    if (n < 0) return 1

    def fact_support(n: Int, acc: Int): Int =
      if (n == 0 || n == 1)
        acc
      else
        fact_support(n - 1, n * acc)

    fact_support(n, 1)
  }

  def digitsOf(n: Int) = n.toString.toCharArray.map(_ - '0')
  def digitsOf(n: Long) = n.toString.toCharArray.map(_ - '0')
  def digitsOf(n: Short) = n.toString.toCharArray.map(_ - '0')

  def lastDigitsOf(n: BigInt, digits: Int) =
    n % (BigInt(10).pow(digits))

  def divisorsOf(n: Int) =
    for (i <- 1 to n / 2; if n % i == 0)
      yield i
  

  def isPalindromic(n: Long) = {
    val str = n.toString
    str.reverse == str
  }

  def isBinaryPalindromic(n: Int) = {
    val str = n.toBinaryString
    str.reverse == str
  }
 
  def isBinaryPalindromic(n: Long) = {
    val str = n.toBinaryString
    str.reverse == str
  }

  def isPrime(n: Int) = {
    def checkPrime(n: Int, cap: Int, divisor: Int): Boolean = {
      if (divisor >= cap)
        true
      else if (n % divisor == 0)
        false
      else
        checkPrime(n, cap, divisor + 2)
    }
    if (n == 2)
      true
    else if (n % 2 == 0)
      false
    else {
      val cap = sqrt(n).toInt
      
      checkPrime(n, cap, 3)
    }
  }

  def intPow(n: Int, p: Int) = {
    if (p == 0) 1
    else {
      var res = 1
      for (i <- 1 to p)
        res *= n

      res
    }
  }
}
