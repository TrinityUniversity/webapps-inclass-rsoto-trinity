import org.scalatestplus.play._
import models._

class TaskListInMemoryModelSpec extends PlaySpec {
    "TaskListInMemoryModel" must {
    "do valid login for default user" in {
        TaskListInMemoryModel.validateUser("Ryan","pass") mustBe (true)
        }

    "reject login with wrong password" in {
        TaskListInMemoryModel.validateUser("Ryan","password") mustBe (false)
        }

    "reject login with wrong username" in {
        TaskListInMemoryModel.validateUser("Roger","pass") mustBe (false)
        }
    
    "reject login with wrong username and password" in {
        TaskListInMemoryModel.validateUser("Roger","password") mustBe (false)
        }

    "get correct default tasks" in {
        TaskListInMemoryModel.getTasks("Ryan") mustBe(List("make videos", "eat", "sleep", "code"))
    }

    "create new user with no tasks" in {
        TaskListInMemoryModel.createUser("Roger","password") mustBe (true)
        TaskListInMemoryModel.getTasks("Roger") mustBe(Nil)
    }

    "create new user with existing name" in {
        TaskListInMemoryModel.createUser("Ryan","password") mustBe (false)
    }

    "add new task for default user" in {
        TaskListInMemoryModel.addTask("Ryan", "testing")
        TaskListInMemoryModel.getTasks("Ryan") must contain ("testing")
    }

    "add new task for new user" in {
        TaskListInMemoryModel.addTask("Roger", "testing1")
        TaskListInMemoryModel.getTasks("Roger") must contain ("testing1")
    }

    "remove task from default user" in {
        TaskListInMemoryModel.removeTasks("Ryan", TaskListInMemoryModel.getTasks("Ryan").indexOf("eat"))
        TaskListInMemoryModel.getTasks("Ryan") must not contain ("eat")
    }

    }
}