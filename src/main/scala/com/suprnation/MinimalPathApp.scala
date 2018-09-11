package com.suprnation

class MinimalPathApp extends TriangleParsing {

  def run(triangleLines: List[String]): Either[String, TrianglePath] = parseTriangle(triangleLines).map(MinimalTrianglePath.calculate)
}

object MinimalPathApp extends App  {
  val appRunner = new MinimalPathApp
  val lines = Iterator.continually(scala.io.StdIn.readLine()).takeWhile(_.nonEmpty)
  appRunner.run(lines.toList) match {
    case Left(errors) => println(s"Errors found in input triangle: $errors")
    case Right(path) => println(s"Minimal triangle path is: $path")
  }

}