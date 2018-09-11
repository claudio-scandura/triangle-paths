package com.suprnation

import com.suprnation.MinimalTrianglePath.Triangle


trait TriangleParsing {

  def parseTriangle(lines: List[String]): Either[String, Triangle] = {
    Left("Triangle must contain at least a digit")
  }
}
