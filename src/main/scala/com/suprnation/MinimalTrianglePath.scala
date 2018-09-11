package com.suprnation

object MinimalTrianglePath {
  type Triangle = Array[Array[Int]]

  def calculate(triangle: Triangle): Seq[Int] = {
    Seq(triangle(0)(0))
  }


}
