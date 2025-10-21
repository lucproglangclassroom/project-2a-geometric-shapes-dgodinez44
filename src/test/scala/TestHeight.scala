package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*

class TestHeight extends AnyFunSuite:
  test("simple ellipse"):
    assert(height(simpleEllipse) == 1)

  test("simple rectangle"):
    assert(height(simpleRectangle) == 1)

  test("simple location"):
    assert(height(simpleLocation) == 2)

  test("basic group"):
    assert(height(basicGroup) == 2)

  test("simple group"):
    assert(height(simpleGroup) == 3)

  test("complex group")
    assert(height(complexGroup) == 6)

end TestHeight
