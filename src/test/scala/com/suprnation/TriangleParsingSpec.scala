package com.suprnation

import com.suprnation.MinimalTrianglePath.Triangle
import org.scalatest.{EitherValues, Matchers, WordSpec}

class TriangleParsingSpec extends WordSpec with Matchers with EitherValues {

  "Parsing a list of strings into a triangle" should {

    "return an error" when {

      "the list is empty" in new TriangleParsing {
        parseTriangle(List.empty) shouldBe Left("Triangle must contain at least a digit")
      }

      "any of the strings contains non numerical characters" in new TriangleParsing {
        val lines = List("23", "12 90", "1 18 foo")
        parseTriangle(lines) shouldBe Left("Triangle must contain only digits")
      }

      "any of the strings contains the wrong number of digits" in new TriangleParsing {
        val lines = List("23", "12 90", "1 18 20 11")
        parseTriangle(lines) shouldBe Left("Line 3 of triangle must contain 3 digits only")
      }
    }

    "accumulate errors" when {
      "there are multiple errors" in new TriangleParsing {
        val lines = List("23", "12 90 1", "1 18 foo")
        val result = parseTriangle(lines)

        result.left.value should (include("Triangle must contain only digits") and include("Line 2 of triangle must contain 2 digits only"))
      }
    }

    "return a triangle" when {
      "the string represent a valid triangle" in new TriangleParsing {
        val lines = List("23", "12 90", "1 18 10", "99 34 6 7", "129 434 64 79 1234")
        val result = parseTriangle(lines)

        result.right.value shouldBe Array(
          Array(23),
          Array(12, 90),
          Array(1, 18, 10),
          Array(99, 34, 6, 7),
          Array(129, 434, 64, 79, 1234)
        )
      }
    }

    "ignore white spaces" in new TriangleParsing {
      val lines = List("   23", "12    90 ", "1     18 10  ", "    99 34 6 7 ", "129 434 64 79 1234")
      parseTriangle(lines) shouldBe a[Right[_, Triangle]]
    }

  }
}
