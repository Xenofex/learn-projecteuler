package projecteuler

import scala.collection.mutable.HashSet

object Problem21 {

  val N = 10000
  val nonAmicable = new HashSet[Int]
  val amicable = new HashSet[Int]
  val divisors = new HashSet[Int]
  val prime = new Prime(N)

  def d(n: Int) = {
    divisors.clear
    for (i <- 1 to n / 2)
      if (n % i == 0)
        divisors += i
    
    (0 /: divisors)(_ + _)
  }

  def main(args: Array[String]) {

    var sumOfDivisors = 0
    for (i <- 1 to N) {
      if (!((nonAmicable contains i) || (amicable contains i))) {
        sumOfDivisors = d(i)
        if (i == d(sumOfDivisors)) {
          if (i != sumOfDivisors) {
            amicable += i
            amicable += sumOfDivisors
          } else {
            nonAmicable += i
            nonAmicable += sumOfDivisors
          }
          
        }
      }
    }
    println(d(220))
    println(nonAmicable.size)
    println(amicable)
    println( (0 /: amicable)(_ + _) )
  }

  
}
