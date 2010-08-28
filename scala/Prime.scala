package projecteuler

import scala.collection.mutable.ArrayBuffer

class Prime(n: Int) {
 
  def this() = this(100)

  private var cursor = 0
  private var a = ArrayBuffer.fill(n + 1)(true)

  val all = new ArrayBuffer[Int]
  
  for (p <- 2 to n) {
    if (a(p) == true) {
      all += p

      for (i <- p + p to n by p)
        a(i) = false
    }
  }

  def next() = {
    if (cursor >= all.length - 1)
      expand()
    
    cursor += 1
    all(cursor - 1)
  }

  def reset() {
    cursor = 0
  }

  def expand() {
    val length = a.size - 1

    a ++= ArrayBuffer.fill(length * 2)(true)
    val n = a.size - 1
    var ii = 0
    
    for {
      i <- all
      j <- length / i * i + i to n by i
    } a(j) = false
    
    for (p <- length + 1 to n) {
      if (a(p) == true) {
        all += p

        for (i <- p + p to n by p)
          a(i) = false
      }
    }
      
  }

  def apply(n: Int) = {
    while (n > all.size)
      expand()
    
    all(n - 1)
  }
  
  
}
