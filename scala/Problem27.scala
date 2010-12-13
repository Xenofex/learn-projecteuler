package projecteuler

import projecteuler.util._

object Problem27 {

  def checkPrime(a: Int, b: Int) = {
    def checkWithCount(a: Int, b: Int, count: Int): Int = {
      val n = count * count + a * count + b
      if (n < 0 || !isPrime(n))
        count - 1
      else
        checkWithCount(a, b, count + 1)
    }

    checkWithCount(a, b, 1)
  }

  def main(args: Array[String]) {
    var a, b, n, primeCount = 0

    for (i <- -1000 to 1000;
         j <- -1000 to 1000) {
      primeCount = checkPrime(i, j)
      if (primeCount >= n) {
        n = primeCount
        a = i
        b = j
      }
    }

    printf("a = %d, b= %d, n = %d\n", a, b, n)
  }

}
