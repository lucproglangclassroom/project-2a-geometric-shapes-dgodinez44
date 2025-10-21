package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import org.slf4j.LoggerFactory

object boundingBox:
  private val logger = LoggerFactory.getLogger(getClass)

  def apply(s: Shape): Location =
    logger.debug(s"Computing bounding box for: $s")
    val result: Location = s match
      case Rectangle(w, h) =>
        Location(0, 0, Rectangle(w, h))

      case Ellipse(w, h) =>
        Location(-w, -h, Rectangle(2 * w, 2 * h))

      case Location(x, y, shape) =>
        val innerBox = apply(shape)
        Location(x + innerBox.x, y + innerBox.y, innerBox.shape)

      case Group(shapes*) =>
        val boxes = shapes.map(apply)
        val lefts = boxes.map { case Location(x, _, _) => x }
        val rights = boxes.map { case Location(x, _, Rectangle(w, _)) => x + w }
        val tops = boxes.map { case Location(_, y, _) => y }
        val bottoms = boxes.map { case Location(_, y, Rectangle(_, h)) => y + h }

        val minX = lefts.min
        val maxX = rights.max
        val minY = tops.min
        val maxY = bottoms.max

        Location(minX, minY, Rectangle(maxX - minX, maxY - minY))

    logger.debug(s"Bounding box result: $result")
    result

end boundingBox