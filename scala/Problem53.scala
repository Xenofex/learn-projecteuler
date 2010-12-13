package projecteuler

import projecteuler.util._
import scala.math._

object Problem53 {

  val exceeds = 1000000
  val maxC = 100

  class CombinationIndexedSeq(n: Int) extends IndexedSeq[BigInt] {
    def length = n + 1;
    def apply(i: Int) = combinations(n, i)
  }

  def main(args: Array[String]) {
    var sum = 0
    for {
      i <- 1 to maxC
      seq = new CombinationIndexedSeq(i)
      x = seq.length - binarySearchInBetween(
	seq, BigInt(exceeds), (seq.length + 1) / 2 - 1) * 2 - 2
      y = max(0, x)
    } sum += y

    println("Result for Problem 53: " + sum)
  }
}
