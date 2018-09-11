package com.suprnation

import org.scalatest.{LoneElement, Matchers, WordSpec}

class MinimalTrianglePathSpec extends WordSpec with Matchers with LoneElement {

  "calculating the minimum triangle path" should {

    "return the only element in the triangle" in {
      val onlyElement = 32
      val input = Array(
        Array(onlyElement)
      )

      val actualPath = MinimalTrianglePath.calculate(input)
      actualPath.loneElement shouldBe onlyElement
    }

  }

}