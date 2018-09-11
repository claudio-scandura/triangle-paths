package com.suprnation

import scala.annotation.tailrec

case class TrianglePath(nodes: Seq[Int]) extends Comparable[TrianglePath] {
  val sum = nodes.sum

  def withPrependedNode(node: Int) = this.copy(node +: nodes)

  override def compareTo(other: TrianglePath): Int = sum.compareTo(other.sum)

  override def toString: String = s"${nodes.mkString("", " + ", " = ")}$sum"
}

object TrianglePath {
  def apply(node: Int): TrianglePath = TrianglePath(Seq(node))

  def min(one: TrianglePath, other: TrianglePath) = if (one.compareTo(other) <= 0) one else other
}

object MinimalTrianglePath {
  type Triangle = Array[Array[Int]]

  def calculate(triangle: Triangle): TrianglePath = {
    require(triangle.nonEmpty, "Triangle needs to be non empty.")

    @tailrec
    def calculate(row: Int, minimalPaths: IndexedSeq[TrianglePath]): TrianglePath = row match {
      case 0 => minimalPaths.head
      case _ =>
        val updatedMinimalPaths = triangle(row - 1).zipWithIndex.take(row).map {
          case (node, column) => TrianglePath.min(minimalPaths(column), minimalPaths(column + 1)).withPrependedNode(node)
        }

        calculate(row - 1, updatedMinimalPaths)
    }

    calculate(triangle.length - 1, toSingleNodePaths(triangle(triangle.length - 1)))
  }

  private def toSingleNodePaths(row: Array[Int]) = row.map(TrianglePath(_))

}

