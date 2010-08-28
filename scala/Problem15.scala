package projecteuler

object Problem15 {
  
  def main(args: Array[String]) {
    var n = 0
    try {
      n = args(0).toInt
    } catch {
      case _ => exit(0)
    }
    var sum = 0
    for (i <- 1 to n - 1) sum += sumOf1ToN2(i)
    println(sum)
  }

  def sumOf1ToN(n: Int) = n * (n + 1) / 2
  def sumOf1ToN2(n: Int) = {
    var sum = 0
    for (i <- 1 to n + 1) sum += sumOf1ToN(i)
    sum
  }

}
