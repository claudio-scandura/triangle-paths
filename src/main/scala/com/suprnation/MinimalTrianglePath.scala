package com.suprnation

import scala.annotation.tailrec

object MinimalTrianglePath {
  type Triangle = Array[Array[Int]]

  def calculate(triangle: Triangle): (Seq[Int], Int) = {
    require(triangle.nonEmpty, "Triangle needs to be non empty.")

    @tailrec
    def calculate(row: Int, minimalPaths: IndexedSeq[(Seq[Int], Int)]): (Seq[Int], Int) = row match {
      case 0 => minimalPaths.head
      case _ =>
        val updatedMinimalPaths = triangle(row - 1).zipWithIndex.take(row).map {
          case (node, column) =>
            val minPath = if (minimalPaths(column)._2 <= minimalPaths(column + 1)._2) minimalPaths(column) else minimalPaths(column + 1)
            (node +: minPath._1, minPath._2 + node)
        }

        calculate(row - 1, updatedMinimalPaths)
    }

    calculate(triangle.length - 1, toSingleNodePaths(triangle(triangle.length - 1)))
  }

  private def toSingleNodePaths(row: Array[Int]) = row.map(node => (Seq(node), node))

}

