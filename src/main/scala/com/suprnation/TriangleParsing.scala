package com.suprnation

import com.suprnation.MinimalTrianglePath.Triangle

import scala.util.Try


trait TriangleParsing {

  def parseTriangle(lines: List[String]): Either[String, Triangle] = lines match {
    case Nil => Left("Triangle must contain at least a digit")
    case _ =>
      lines.zipWithIndex.map {
        case (line, index) => parseLine(line, index + 1)
      }.foldLeft[Either[String, Triangle]](Right(Array.empty[Array[Int]])) {
        case (l@Left(_), leftOrRight) => leftOrRight.fold(error => Left(s"${l.value}, $error"), _ => l)
        case (_, Left(error)) => Left(error)
        case (Right(triangle), Right(parsedLine)) => Right(triangle :+ parsedLine)
      }

  }

  private def parseLine(line: String, lineIndex: Int): Either[String, Array[Int]] = Try {
    line.split(" ")
      .filter(_.nonEmpty)
      .map(_.trim.toInt)
  }.toOption.fold[Either[String, Array[Int]]](Left("Triangle must contain only digits")) {
    case digits if digits.size != lineIndex => Left(s"Line $lineIndex of triangle must contain $lineIndex digits only")
    case digits => Right(digits)
  }
}
