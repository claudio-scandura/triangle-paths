package com.suprnation

object MinimalTrianglePath {
  type Triangle = Array[Array[Int]]

  def calculate(triangle: Triangle): Seq[Int] = {
    require(triangle.nonEmpty, "Triangle needs to be non empty.")
    Seq(triangle(0)(0))
  }


}
