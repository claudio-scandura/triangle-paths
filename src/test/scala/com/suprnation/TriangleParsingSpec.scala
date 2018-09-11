package com.suprnation

import org.scalatest.{Matchers, WordSpec}

class TriangleParsingSpec extends WordSpec with Matchers {

  "Parsing a list of string into a triangle" should {

    "return an error" when {

       "the list is empty" in new TriangleParsing {
         parseTriangle(List.empty) shouldBe Left("Triangle must contain at least a digit")
       }
    }

  }
}
