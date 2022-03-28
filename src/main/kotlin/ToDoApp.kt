class ToDoApp {

    data class TaskToDo(
        val name: String,
        var isCheck: Boolean
    )

    val toDoList = mutableListOf<TaskToDo>()

    // -------------
    //  ADD METHODS
    // -------------

    fun addNewTask(task: TaskToDo) {
        toDoList.add(task)
    }

    // ------------------
    //  CHECKBOX METHODS
    // ------------------

    fun checkATaskByIndex(indexTask: Int) {
        if (indexTask < toDoList.size) {
            toDoList[indexTask].isCheck = true
        }
    }

    fun checkATaskByName(taskName: String) {

//        for (task in toDoList) {
//            if (task.name == taskName) {
//                task.isCheck = true
//                break
//            }
//        }

        toDoList.find { it.name == taskName }?.isCheck = true

    }

    fun unCheckATaskByIndex(indexTask: Int) {
        if (indexTask < toDoList.size) {
            toDoList[indexTask].isCheck = false
        }
    }

    fun unCheckATaskByName(taskName: String) {

//        for (task in toDoList) {
//            if (task.name == taskName) {
//                task.isCheck = false
//                break
//            }
//        }

        toDoList.find { it.name == taskName }?.isCheck = false

    }

    // ----------------
    //  REMOVE METHODS
    // ----------------

    fun removeTaskByIndex(indexTask: Int) {
        toDoList.removeAt(indexTask)
    }

    // ----------------
    //  SORT METHODS
    // ----------------

    fun sortToDoListByTaskNames() {
        toDoList.sortBy { it.name }
    }

    fun sortToDoListByTaskChecked() {
        toDoList.sortWith(compareBy<TaskToDo> { it.isCheck }.thenBy { it.name })
    }


}