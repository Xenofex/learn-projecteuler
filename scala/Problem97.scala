package projecteuler

import Util._
import scala.math._

object Problem97 extends Application {
  //28433 * 2^7830457 + 1
  
  val a = 28433
  val n = 7830457

  def lastTen(m: BigInt, p: Int) = {
    var a = m
    for (i <- 1 to p) {
      a *= a
      a = lastDigitsOf(a, 10)
    }

    lastDigitsOf(a, 10)
  }

  def getLastTen(n: BigInt, power: Int): BigInt = {


    val l = (log(power.toDouble) / log(2)).toInt
    val remains = power - intPow(2, l)
    //println("   l = " + l + " remains = " + remains)
    
    if (l == 0)
      lastDigitsOf(n, 10)
    else if (remains == 0)
      lastTen(n, l)
    else {
      //println(" --lastTen = " + lastTen(n, l))
      lastDigitsOf(lastTen(n, l) * getLastTen(n, remains), 10)
    }
      
  }

  //println(getLastTen(BigInt(2), 1))
  //println(getLastTen(BigInt(2), 3))

  val r = lastDigitsOf(getLastTen(2, n) * a + 1, 10)

  println(r)
}
