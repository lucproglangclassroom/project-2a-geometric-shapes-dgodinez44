package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  test("scale simple rectangle by 2"):
    val scaled = scale(simpleRectangle, 2.0)
    assert(scaled == Rectangle(160, 240))

  test("scale simple ellipse by 0.5"):
    val scaled = scale(simpleEllipse, 0.5)
    assert(scaled == Ellipse(25, 15))

  test("scale simple location by 2"):
    val scaled = scale(simpleLocation, 2.0)
    assert(scaled == Location(140, 60, Rectangle(160, 240)))

  test("scale basic group by 3"):
    val scaled = scale(basicGroup, 3.0)
    assert(scaled == Group(Ellipse(150, 90), Rectangle(60, 120)))

  test("scale simple group by 0.5"):
    val scaled = scale(simpleGroup, 0.5)
    val expected = Group(
      Location(100, 50, Ellipse(25, 15)),
      Location(200, 150, Rectangle(50, 25))
    )
    assert(scaled == expected)

  test("scale complex group"):
    val scaled = scale(complexGroup, 2.0)
    assert(size(scaled) == size(complexGroup))

end TestScale