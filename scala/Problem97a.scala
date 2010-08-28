package projecteuler

object Problem97a extends Application {
  def loop(n: Int)(proc: => Unit) {
    def loopSupport(nth: Int, total: Int, proc: => Unit) {
      if (nth < total) {
        proc
        loopSupport(nth + 1, total, proc)
      }
    }

    loopSupport(0, n, proc)
  }

//  var res = 1L
//  for (i <- 1 to 7830457) {
//  loop(7830457) {
    // while loop is much more faster than the above 2
/*  var n = 0
  while (n < 7830457) {
    res <<= 1
    res %= 10000000000L
    n += 1
  } */
  var res = BigInt(2L)
  res = res.modPow(BigInt(7830457), BigInt(10000000000L))

  res *= 28433
  res %= 10000000000L
  res += 1
  println(res)
}
