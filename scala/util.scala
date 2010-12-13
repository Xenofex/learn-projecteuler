package projecteuler

import scala.math._

package object util {
  
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

  def combinations(n: BigInt, r: BigInt) = {
    //println("n = " + n + " r = " + r)
    if (n < 0 || r < 0)
      throw new ArithmeticException("n and r must be both non-negative integers.")

    if (r > n) BigInt(0)
    else if (r == n || r == 0) BigInt(1)
    else {
      var result = BigInt(1)
      val r2 = if (r > n / 2) n - r else r
      for (i <- BigInt(1) to r2) result = result * (n + BigInt(1) - i) / i

      result
    }
  }

  /**
   * see http://rosettacode.org/wiki/Binary_search#Scala
   */
  def binarySearch[T <% Ordered[T]](a: IndexedSeq[T], v: T) = {
    def recurse(low: Int, high: Int): Option[Int] = (low + high) / 2 match {
      case _ if high < low => None
      case mid if a(mid) > v => recurse(low, mid - 1)
      case mid if a(mid) < v => recurse(mid + 1, high)
      case mid => Some(mid)
    }
    recurse(0, a.size - 1)
  }

  /**
   * Search the index that at a(index) < v <= a(index + 1). The IndexedSeq
   * a must be sorted ascendingly before hand.
   * @returns -1 if v < a(0); a.length if a.last < v; else return index
   */
  def binarySearchInBetween[T <% Ordered[T]](a: IndexedSeq[T],
					     v: T,
					     lower: Int,
					     higher: Int) = {
    def recurse(low: Int, high: Int): Int = (low + high) / 2 match {
      case mid if a(mid + 1) < v => recurse(mid + 1, high)
      case mid if v <= a(mid) => recurse(low, mid - 1)
      case mid => mid
    }
    val l = max(0, lower)
    val h = min(a.length - 1, higher)
    
    if (v < a(l)) l - 1
    else if (a(h) < v) h + 1
    else recurse(l, h - 1)
  }

  def binarySearchInBetween[T <% Ordered[T]](a: IndexedSeq[T], v: T): Int =
    binarySearchInBetween(a, v, 0, a.length - 1)

  def binarySearchInBetween[T <% Ordered[T]](
    a: IndexedSeq[T], v: T, higher: Int): Int =
      binarySearchInBetween(a, v, 0, higher)
					       
					       
}
