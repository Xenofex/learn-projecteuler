package projecteuler

object Problem25 {
  def main(args: Array[String]) {
    var a, b, c = BigInt(1)
    var term = 2
    
    while (c.toString.length < 1000) {
      term += 1
      c = a + b
      a = b
      b = c
    }

    println(term)
  }

}
