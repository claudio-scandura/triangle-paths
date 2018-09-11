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
      actualPath._1.loneElement shouldBe onlyElement
      actualPath._2 shouldBe onlyElement
    }

    "throw exception if triangle is empty" in {
      an[IllegalArgumentException] shouldBe thrownBy(MinimalTrianglePath.calculate(Array.empty))
    }

    "return the path with the smallest sum in the triangle" when {
      "there is a unique smallest path" in {
        val input = Array(
          Array(7, 0, 0, 0),
          Array(6, 3, 0, 0),
          Array(3, 8, 5, 0),
          Array(11, 2, 10, 9)
        )

        val actualPath = MinimalTrianglePath.calculate(input)
        actualPath._1 should contain theSameElementsInOrderAs Seq(7, 6, 3, 2)
        actualPath._2 shouldBe 18
      }

      "there are more minimal paths with equal sum" in {
        val input = Array(
          Array(7, 0, 0, 0),
          Array(6, 2, 0, 0),
          Array(3, 8, 5, 0),
          Array(11, 2, 4, 9)
        )
        //path 7 -> 2 -> 5 -> 4 is also minimal
        MinimalTrianglePath.calculate(input)._2 shouldBe 18
      }

      "there are duplicate minimal paths" in {
        val input = Array(
          Array(7, 0, 0, 0),
          Array(6, 6, 0, 0),
          Array(3, 3, 5, 0),
          Array(11, 2, 10, 9)
        )

        val actualPath = MinimalTrianglePath.calculate(input)
        actualPath._1 should contain theSameElementsInOrderAs Seq(7, 6, 3, 2)
        actualPath._2 shouldBe 18
      }

      "there paths with negative numbers" in {
        val input = Array(
          Array(7, 0, 0, 0),
          Array(6, -13, 0, 0),
          Array(-3, 8, 5, 0),
          Array(11, -2, 10, 9)
        )

        val actualPath = MinimalTrianglePath.calculate(input)
        actualPath._1 should contain theSameElementsInOrderAs Seq(7, -13, 8, -2)
        actualPath._2 shouldBe 0
      }

    }
  }

}