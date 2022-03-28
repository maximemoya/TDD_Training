import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ToDoAppTest {

    // -------------
    //  CONSTRUCTOR
    // -------------

    // The instantiation of ToDoApp class has one list<TaskToDo> empty
    @Test
    fun initToDoList() {
        // Context :
        val myToDoApp = ToDoApp()
        // Execution :
        expectThat(myToDoApp.toDoList.size).isEqualTo(0)
    }

    // -------------
    //  ADD METHODS
    // -------------

    // The method addNewTask, add one task to the toDoList
    @Test
    fun add1TaskToTheToDoList() {
        // Context :
        val myToDoApp = ToDoApp()
        // Test method :
        val toDoListToTest = myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", false))
        // Execution :
        expectThat(toDoListToTest.size).isEqualTo(1)
        expectThat(toDoListToTest[0].name).isEqualTo("name0")
        expectThat(toDoListToTest[0].isCheck).isEqualTo(false)
    }

    // The method add 2 tasks to the toDoList
    // sort by checked then alphabetical order
    @Test
    fun add2TasksToTheToDoList() {
        // Context :
        val myToDoApp = ToDoApp()
        // Test method :
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", false))
        val toDoListToTest = myToDoApp.addNewTask(ToDoApp.TaskToDo("name1", false))
        // Execution :
        expectThat(toDoListToTest.size).isEqualTo(2)
        expectThat(toDoListToTest[0].name).isEqualTo("name0")
        expectThat(toDoListToTest[0].isCheck).isEqualTo(false)
        expectThat(toDoListToTest[1].name).isEqualTo("name1")
        expectThat(toDoListToTest[1].isCheck).isEqualTo(false)
    }

    // The method add 3 tasks to the toDoList
    // sort by checked then alphabetical order
    @Test
    fun add3TasksToTheToDoList() {
        // Context :
        val myToDoApp = ToDoApp()
        // Test method :
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name2", true))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", true))
        val toDoListToTest = myToDoApp.addNewTask(ToDoApp.TaskToDo("name1", false))
        // Execution :
        expectThat(toDoListToTest.size).isEqualTo(3)
        expectThat(toDoListToTest[0].name).isEqualTo("name1")
        expectThat(toDoListToTest[0].isCheck).isEqualTo(false)
        expectThat(toDoListToTest[1].name).isEqualTo("name0")
        expectThat(toDoListToTest[1].isCheck).isEqualTo(true)
        expectThat(toDoListToTest[2].name).isEqualTo("name2")
        expectThat(toDoListToTest[2].isCheck).isEqualTo(true)
    }

    // ----------------
    //  REMOVE METHODS
    // ----------------

    // The method remove 1 task from the toDoList of 1 task, according input ID
    @Test
    fun removeTaskToTheToDoList() {
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", false))
        // Test method :
        val toDoListToTest = myToDoApp.removeTaskById(0)
        // Execution :
        expectThat(toDoListToTest.size).isEqualTo(0)
    }

    // The method remove 1 task from the toDoList of 2 tasks, according input ID
    // get list sort by checked then alphabetical
    @Test
    fun remove1TaskToTheToDoList() {
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", true))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name1",false))
        // Test method :
        val toDoListToTest = myToDoApp.removeTaskById(0)
        // Execution :
        expectThat(toDoListToTest.size).isEqualTo(1)
        expectThat(toDoListToTest[0].name).isEqualTo("name0")
        expectThat(toDoListToTest[0].isCheck).isEqualTo(true)
    }

    // The method remove 3 tasks from the toDoList of 5 tasks, according input ID
    // get list sort by checked then alphabetical
    @Test
    fun remove2TasksToTheToDoList() {
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", true))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name1", true))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name3", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name2", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name4", false))
        // Test method :
        myToDoApp.removeTaskById(0)
        val toDoListToTest = myToDoApp.removeTaskById(2)
        // Execution :
        expectThat(toDoListToTest.size).isEqualTo(3)
        expectThat(toDoListToTest[0].name).isEqualTo("name3")
        expectThat(toDoListToTest[0].isCheck).isEqualTo(false)
        expectThat(toDoListToTest[1].name).isEqualTo("name4")
        expectThat(toDoListToTest[1].isCheck).isEqualTo(false)
        expectThat(toDoListToTest[2].name).isEqualTo("name1")
        expectThat(toDoListToTest[2].isCheck).isEqualTo(true)

    }

    // ------------------
    //  CHECKBOX METHODS
    // ------------------

    // The method checkATaskByIndex set the Task attribute ischeck to true
    @Test
    fun checkATaskByIndex() {
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", false))
        // Test method :
        val isCheckToTest = myToDoApp.checkATaskById(0)
        // Execution :
        expectThat(isCheckToTest).isEqualTo(true)
    }

    // The method checkATaskByName set the Task attribute ischeck to true
    @Test
    fun checkATaskByName() {
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", false))
        // Test method :
        val isCheckToTest = myToDoApp.checkATaskByName("name0")
        // Execution :
        expectThat(isCheckToTest).isEqualTo(true)
    }

    // The method unCheckATaskByIndex set the Task attribute ischeck to false
    @Test
    fun unCheckATaskByIndex() {
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", true))
        // Test method :
        val isCheckToTest = myToDoApp.unCheckATaskById(0)
        // Execution :
        expectThat(isCheckToTest).isEqualTo(false)
    }

    // The method unCheckATaskByName set the Task attribute ischeck to false
    @Test
    fun unCheckATaskByName() {
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", true))
        // Test method :
        val isCheckToTest = myToDoApp.unCheckATaskByName("name0")
        // Execution :
        expectThat(isCheckToTest).isEqualTo(false)
    }

    // ----------------
    //  SORT METHODS
    // ----------------

    // The method setSortingSelection set the Sorting of the list referenced by the ToDoApp.SortingSelectionEnum :
    @Test
    fun changeListSortSelection() {
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", true))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name3", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name2", true))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name5", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name4", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name1", false))
        // Test method :
        var toDoListToTest = myToDoApp.setSortingSelection(ToDoApp.SortingSelectionEnum.BYNAME)
        // Execution :
        expectThat(toDoListToTest.size).isEqualTo(6)
        expectThat(toDoListToTest[0].name).isEqualTo("name0")
        expectThat(toDoListToTest[0].isCheck).isEqualTo(true)
        expectThat(toDoListToTest[1].name).isEqualTo("name1")
        expectThat(toDoListToTest[1].isCheck).isEqualTo(false)
        expectThat(toDoListToTest[2].name).isEqualTo("name2")
        expectThat(toDoListToTest[2].isCheck).isEqualTo(true)
        expectThat(toDoListToTest[3].name).isEqualTo("name3")
        expectThat(toDoListToTest[3].isCheck).isEqualTo(false)
        expectThat(toDoListToTest[4].name).isEqualTo("name4")
        expectThat(toDoListToTest[4].isCheck).isEqualTo(false)
        expectThat(toDoListToTest[5].name).isEqualTo("name5")
        expectThat(toDoListToTest[5].isCheck).isEqualTo(false)
        // Test method :
        toDoListToTest = myToDoApp.setSortingSelection(ToDoApp.SortingSelectionEnum.BYCHECKEDTHENBYNAME)
        expectThat(toDoListToTest.size).isEqualTo(6)
        expectThat(toDoListToTest[0].name).isEqualTo("name1")
        expectThat(toDoListToTest[0].isCheck).isEqualTo(false)
        expectThat(toDoListToTest[1].name).isEqualTo("name3")
        expectThat(toDoListToTest[1].isCheck).isEqualTo(false)
        expectThat(toDoListToTest[2].name).isEqualTo("name4")
        expectThat(toDoListToTest[2].isCheck).isEqualTo(false)
        expectThat(toDoListToTest[3].name).isEqualTo("name5")
        expectThat(toDoListToTest[3].isCheck).isEqualTo(false)
        expectThat(toDoListToTest[4].name).isEqualTo("name0")
        expectThat(toDoListToTest[4].isCheck).isEqualTo(true)
        expectThat(toDoListToTest[5].name).isEqualTo("name2")
        expectThat(toDoListToTest[5].isCheck).isEqualTo(true)
    }

}