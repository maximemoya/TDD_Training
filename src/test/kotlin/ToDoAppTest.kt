import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ToDoAppTest {

    // -------------
    //  CONSTRUCTOR
    // -------------

    // The instantiation of ToDoApp class has one list<TaskToDo> empty
    @Test
    fun initToDoList(){
        val myToDoApp = ToDoApp()

        expectThat(myToDoApp.toDoList.size).isEqualTo(0)
    }

    // -------------
    //  ADD METHODS
    // -------------

    // The method add one task to the toDoList
    @Test
    fun addTaskToTheToDoList(){
        // Context :
        val myToDoApp = ToDoApp()
        // Test method :
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", false))
        // Execution :
        expectThat(myToDoApp.toDoList.size).isEqualTo(1)
    }

    // The method add used twice add the tasks to the toDoList
    @Test
    fun addTwiceTaskToTheToDoList(){
        // Context :
        val myToDoApp = ToDoApp()
        // Test method :
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name1", false))
        // Execution :
        expectThat(myToDoApp.toDoList.size).isEqualTo(2)
    }

    // ------------------
    //  CHECKBOX METHODS
    // ------------------

    // The method checkATaskByIndex set the Task attribute ischeck to true
    @Test
    fun checkATaskByIndex(){
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", false))
        // Test method :
        myToDoApp.checkATaskByIndex(0)
        // Execution :
        expectThat(myToDoApp.toDoList[0].isCheck).isEqualTo(true)
    }

    // The method checkATaskByName set the Task attribute ischeck to true
    @Test
    fun checkATaskByName(){
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", false))
        // Test method :
        myToDoApp.checkATaskByName("name0")
        // Execution :
        expectThat(myToDoApp.toDoList[0].isCheck).isEqualTo(true)
    }

    // The method unCheckATaskByIndex set the Task attribute ischeck to false
    @Test
    fun unCheckATaskByIndex(){
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", true))
        // Test method :
        myToDoApp.unCheckATaskByIndex(0)
        // Execution :
        expectThat(myToDoApp.toDoList[0].isCheck).isEqualTo(false)
    }

    // The method unCheckATaskByName set the Task attribute ischeck to false
    @Test
    fun unCheckATaskByName(){
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", true))
        // Test method :
        myToDoApp.unCheckATaskByName("name0")
        // Execution :
        expectThat(myToDoApp.toDoList[0].isCheck).isEqualTo(false)
    }

    // ----------------
    //  REMOVE METHODS
    // ----------------

    // The method removeTaskByIndex remove one task according to its indexId in toDoList
    @Test
    fun removeTaskByIdToTheToDoList(){
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", false))
        // Test method :
        myToDoApp.removeTaskByIndex(0)
        // Execution :
        expectThat(myToDoApp.toDoList.size).isEqualTo(0)
    }

    // The method removeTaskByIndex used twice remove the tasks according to their actualizedIndexId in toDoList
    @Test
    fun remove2TimesATaskByIdToTheToDoList(){
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name0", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name1", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name2", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name3", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("name4", false))
        // Test method :
        myToDoApp.removeTaskByIndex(0)
        myToDoApp.removeTaskByIndex(2)
        // Execution :
        expectThat(myToDoApp.toDoList[0].name).isEqualTo("name1")
        expectThat(myToDoApp.toDoList[1].name).isEqualTo("name2")
        expectThat(myToDoApp.toDoList[2].name).isEqualTo("name4")

    }

    // ----------------
    //  SORT METHODS
    // ----------------

    // The method sortToDoListByTaskNames as to sort toDoList by its task'sNames alphabetically
    @Test
    fun sortToDoListByTaskNames(){
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("go to run", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("go to buy vegetables", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("watch all videos about programming", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("pickup friend from the station on wednesday", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("learn how to program in TDD", false))
        // Test method :
        myToDoApp.sortToDoListByTaskNames()
        // Execution :
        expectThat(myToDoApp.toDoList[0].name).isEqualTo("go to buy vegetables")
        expectThat(myToDoApp.toDoList[1].name).isEqualTo("go to run")
        expectThat(myToDoApp.toDoList[2].name).isEqualTo("learn how to program in TDD")
        expectThat(myToDoApp.toDoList[3].name).isEqualTo("pickup friend from the station on wednesday")
        expectThat(myToDoApp.toDoList[4].name).isEqualTo("watch all videos about programming")

    }

    // The method sortToDoListByTaskChecked as to sort toDoList by its checked state (uncheck to check)
    // then as to sort toDoList by its task'sNames alphabetically
    @Test
    fun sortToDoListByTaskChecked(){
        // Context :
        val myToDoApp = ToDoApp()
        myToDoApp.addNewTask(ToDoApp.TaskToDo("go to run", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("go to buy vegetables", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("watch all videos about programming", true))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("pickup friend from the station on wednesday", false))
        myToDoApp.addNewTask(ToDoApp.TaskToDo("learn how to program in TDD", true))
        // Test method :
        myToDoApp.sortToDoListByTaskChecked()
        // Execution :
        expectThat(myToDoApp.toDoList[0].name).isEqualTo("go to buy vegetables")
        expectThat(myToDoApp.toDoList[1].name).isEqualTo("go to run")
        expectThat(myToDoApp.toDoList[2].name).isEqualTo("pickup friend from the station on wednesday")
        expectThat(myToDoApp.toDoList[3].name).isEqualTo("learn how to program in TDD")
        expectThat(myToDoApp.toDoList[4].name).isEqualTo("watch all videos about programming")

    }

}