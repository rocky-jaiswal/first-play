package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.Solver

object Application extends Controller {

  val myForm = Form (
    "num" -> number.verifying(min(3))
  )

  def index = Action {
    Ok(views.html.index(myForm))
  }

  def show = Action { implicit request => {
      val num = myForm.bindFromRequest.get
      val queens = Solver.queens(num)
      Ok(views.html.show((1 to num).toList, queens))
    }
  }
  
}