package projecteuler

object Problem30 {

  def pow(n: Int, exp: Int): Int =
    if (n == 0)
      0
    else if (exp == 0)
      1
    else 
      pow(n, exp - 1) * n


  def main(args: Array[String]) {

    val num = for {
      i <- 2 to 299999
      sumOfDigits = i.toString.toCharArray.map(
        x => pow(x - '0', 5)).sum
      if (i == sumOfDigits)
    } yield i
    println(pow(2, 3))
    println(num.mkString(", "))
    println(num.sum)
  }

}
