package com.suprnation

import com.suprnation.MinimalTrianglePath.Triangle


trait TriangleParsing {

  def parseTriangle(lines: List[String]): Either[String, Triangle] = {
    if (lines.isEmpty) Left("Triangle must contain at least a digit")
    else Left("Triangle must contain only digits")
  }
}
