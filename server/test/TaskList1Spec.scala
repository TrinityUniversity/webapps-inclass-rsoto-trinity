import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import org.scalatestplus.play.OneBrowserPerSuite
import org.scalatestplus.play.HtmlUnitFactory

class TaskList1Spec extends PlaySpec with GuiceOneServerPerSuite with OneBrowserPerSuite with HtmlUnitFactory {
    "Task List 1" must {
        "login and access function" in{
            go to s"http://localhost:$port/login1"
            eventually{
            find("h2").isEmpty mustBe false
            find("h2").foreach(e=>e.text mustBe "Login")
            click on "username-login"
            textField("username-login").value = "Ryan"
            click on "password-login"
            pwdField("password").value = "pass"
            submit()
            }
        }
    }
}