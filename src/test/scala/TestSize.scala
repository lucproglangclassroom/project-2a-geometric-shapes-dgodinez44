package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*

class TestSize extends AnyFunSuite:
  test("simple ellipse"):
    assert(size(simpleEllipse) == 1)

  test("simple rectangle"):
    assert(size(simpleRectangle) == 1)

  test("simple location"):
    assert(size(simpleLocation) == 1)

  test("basic group"):
    assert(size(basicGroup) == 2)

  test("simple group"):
    assert(size(simpleGroup) == 2)

  test("complex group"):
    assert(size(complexGroup) == 5)

end TestSize
