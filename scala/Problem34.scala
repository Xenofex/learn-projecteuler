package projecteuler

import util._

object Problem34 {

  val factCache = Map(
    1 -> factorial(1),
    2 -> factorial(2),
    3 -> factorial(3),
    4 -> factorial(4),
    5 -> factorial(5),
    6 -> factorial(6),
    7 -> factorial(7),
    8 -> factorial(8),
    9 -> factorial(9),   
    0 -> factorial(0)
  )

  def main(args: Array[String]) {
    val all = for {
      i <- 3 to 2300000
      if i == (0 /: digitsOf(i))( (x, y) => x + factCache(y) )
    } yield i

    println(all.sum)
  }

}
