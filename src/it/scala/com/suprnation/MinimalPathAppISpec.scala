package com.suprnation

import org.scalatest.{EitherValues, Matchers, WordSpec}


class MinimalPathAppISpec extends WordSpec with Matchers with EitherValues {

  "The run method" should {
    "successfully validate the triangle in the input lines and calculate the minimal triangle path" in new MinimalPathApp {
      val input = List("23", "109 -23", "11 87 90", "-34 -9 65 180")
      run(input).right.value shouldBe TrianglePath(Seq(23, -23, 87, -9))
    }

    "fail to validate the triangle in the input lines and return the error description" in new MinimalPathApp {
      val input = List("23", "109 -23", "11 87 90", "-34 -9 65 180 110")
      run(input) shouldBe a[Left[String, _]]
    }
  }

}
