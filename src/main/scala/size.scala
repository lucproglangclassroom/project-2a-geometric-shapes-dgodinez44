package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import org.slf4j.LoggerFactory

object size:
  private val logger = LoggerFactory.getLogger(getClass)

  def apply(s: Shape): Int =
    logger.debug(s"Computing size for: $s")
    val result = s match
      case Rectangle(_, _) => 1
      case Ellipse(_, _) => 1
      case Location(_, _, shape) => apply(shape)
      case Group(shapes*) => shapes.map(apply).sum

    logger.debug(s"Size result: $result")
    result
end size