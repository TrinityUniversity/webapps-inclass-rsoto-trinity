package controllers
import java.util.concurrent.atomic.AtomicInteger

import javax.inject._

import shared.SharedMessages
import play.api.mvc._
import math._


@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  object counter{
  private val counter1 = new AtomicInteger(0);
  def get() = counter1.get()
  def set(v: Int) = counter1.set(v)
  def inc() = counter1.incrementAndGet()
}
  def index = Action { implicit request =>
    Ok(views.html.index(SharedMessages.itWorks))
  }


  def product(prodType: String, prodNum: Int) = Action {
    Ok(s"Product type is $prodType, product number is: $prodNum")
  }

  def randomNumber = Action {
    Ok(util.Random.nextInt(100).toString())
  }

  def randomString(length: Int) = Action {
    Ok(util.Random.nextString(length))
  }


}
