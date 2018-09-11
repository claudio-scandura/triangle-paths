package com.suprnation

import org.scalatest.{Matchers, WordSpec}

class TriangleParsingSpec extends WordSpec with Matchers {

  "Parsing a list of strings into a triangle" should {

    "return an error" when {

       "the list is empty" in new TriangleParsing {
         parseTriangle(List.empty) shouldBe Left("Triangle must contain at least a digit")
       }

      "any of the strings contain non numerical characters" in new TriangleParsing {
        val lines = List("23", "12 90", "1 18 foo")
        parseTriangle(lines) shouldBe Left("Triangle must contain only digits")
      }
    }

  }
}
