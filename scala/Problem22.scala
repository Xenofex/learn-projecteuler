package projecteuler

import scala.io.Source

object Problem22 {

  def main(args: Array[String]) {
    println(weight("abcde"))
    val names = Source.fromPath("names.txt")
                .getLine(1)
                .split(",")
                .map(x => x.substring(1, x.length - 1))
                .sortWith((x, y) => x.compareToIgnoreCase(y) < 0)
    
    var sum = 0
    for (i <- 0 to names.length - 1)
      sum += (i + 1) * weight(names(i))
    println(sum)
  }

  def weight(name: String) = {
    var sum = 0
    for (c <- name.toUpperCase.toCharArray)
      sum += c - 'A' + 1

    sum
  }

}
