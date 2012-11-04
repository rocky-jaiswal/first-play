import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

import models.Solver

class SolverSpec extends Specification {

  "Solver" should {
    "return a blank list if num is less than 4" in {
      Solver.queens(3) must have size(0)
    }

    "return 2 solutions for a board of 4" in {
      Solver.queens(4) must have size(2)
    }
  }

}