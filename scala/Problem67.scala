package projecteuler

import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.math._

object Problem67 {

  def main(args: Array[String]) {
    val buffer = new ListBuffer[Array[BigInt]]
    for (line <- Source.fromFile("triangle.txt").getLines)
      buffer += line.split(" ").map(BigInt(_))

    // val solutionArray = new Array[Array[Long]](buffer.size)
    // for (i <- 0 to buffer.size - 1)
    //   solutionArray(i) = new Array[Int](i + 1)

    val result = (BigInt(0) /: getMaxTo(buffer.size - 1, buffer)) (_ max _)
    println(result)
    
  }

  def getMaxTo(row: Int, buffer: ListBuffer[Array[BigInt]]): Array[BigInt] = {
    if (row == 0)
      Array(buffer(0)(0))
    else {
      val a = new Array[BigInt](row + 1)
      val lastMaxRow = getMaxTo(row - 1, buffer)
      val thisRow = buffer(row)
      a(0) = lastMaxRow(0) + thisRow(0)
      a(row) = lastMaxRow.last + thisRow.last
      for (i <- 1 to row - 1) {
        if (lastMaxRow(i) > lastMaxRow(i - 1))
          a(i) = lastMaxRow(i) + thisRow(i)
        else
          a(i) = lastMaxRow(i - 1) + thisRow(i)
      }
        // a(i) = max(thisRow(i) * lastMaxRow(i), thisRow(i) * lastMaxRow(i + 1))

      a
    }
  }
    

}
