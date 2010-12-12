package projecteuler

object Problem31 {
  def main(args: Array[String]) {
    var sum = 0;
    for {
      h <- 200 to 0 by -200
      g <- h to 0 by -100
      f <- g to 0 by -50
      e <- f to 0 by -20
      d <- e to 0 by -10
      c <- d to 0 by -5
      b <- c to 0 by -2
    } sum += 1

    println("result for problem 31: " + sum.toString)
  }
}
