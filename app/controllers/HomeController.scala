package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, messagesAction: MessagesActionBuilder) extends AbstractController(cc)  with play.api.i18n.I18nSupport {
  import models.LoginForm._
  import models.LoginForm

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def login() = Action {  implicit request =>
    Ok(views.html.login(form))
  }

  def loginSumit = Action { implicit request: Request[AnyContent] =>
      Redirect(routes.HomeController.index())
  }
}
