package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import org.slf4j.LoggerFactory

object scale:
  private val logger = LoggerFactory.getLogger(getClass)

  def apply(s: Shape, factor: Double): Shape =
    logger.debug(s"Scaling shape by factor $factor: $s")
    val result = s match
      case Rectangle(w, h) =>
        Rectangle((w * factor).toInt, (h * factor).toInt)

      case Ellipse(w, h) =>
        Ellipse((w * factor).toInt, (h * factor).toInt)

      case Location(x, y, shape) =>
        Location((x * factor).toInt, (y * factor).toInt, apply(shape, factor))

      case Group(shapes*) =>
        Group(shapes.map(apply(_, factor))*)

    logger.debug(s"Scaled result: $result")
    result
end scale