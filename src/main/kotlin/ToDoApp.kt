class ToDoApp {

    data class TaskToDo(
        val name: String,
        var isCheck: Boolean
    )

    enum class SortingSelectionEnum {
        BYNAME, BYCHECKEDTHENBYNAME
    }

    //--------------
    // ATTRIBUTES :
    //-------------

    val toDoList = mutableListOf<TaskToDo>()

    private var sortingSelection = SortingSelectionEnum.BYCHECKEDTHENBYNAME.ordinal

    // -------------
    //  ADD METHODS
    // -------------

    fun addNewTask(task: TaskToDo): MutableList<TaskToDo> {
        toDoList.add(task)
        sortingMethod()
        return mutableListOf<TaskToDo>().apply { addAll(toDoList) }
    }

    // ----------------
    //  REMOVE METHODS
    // ----------------

    fun removeTaskById(idTask: Int): MutableList<TaskToDo> {
        toDoList.removeAt(idTask)
        sortingMethod()
        return mutableListOf<TaskToDo>().apply { addAll(toDoList) }
    }

    // ------------------
    //  CHECKBOX METHODS
    // ------------------

    fun checkATaskById(idTask: Int): Boolean {
        return if (idTask < toDoList.size) {
            toDoList[idTask].isCheck = true
            toDoList[idTask].isCheck
        } else {
            false
        }
    }

    fun checkATaskByName(taskName: String): Boolean {
        return when (val task = toDoList.find { it.name == taskName }) {
            null -> false
            else -> {
                task.isCheck = true
                task.isCheck
            }
        }
    }

    fun unCheckATaskById(idTask: Int): Boolean {
        return if (idTask < toDoList.size) {
            toDoList[idTask].isCheck = false
            toDoList[idTask].isCheck
        } else {
            true
        }
    }

    fun unCheckATaskByName(taskName: String): Boolean {
        return when (val task = toDoList.find { it.name == taskName }) {
            null -> true
            else -> {
                task.isCheck = false
                task.isCheck
            }
        }
    }

    // ----------------
    //  SORT METHODS
    // ----------------

    fun setSortingSelection(sortingSelectionEnum: SortingSelectionEnum): MutableList<TaskToDo> {
        sortingSelection = sortingSelectionEnum.ordinal
        return sortingMethod()
    }

    private fun sortToDoListByTaskNames(): MutableList<TaskToDo> {
        toDoList.sortBy { it.name }
        return mutableListOf<TaskToDo>().apply { addAll(toDoList) }
    }

    private fun sortToDoListByTaskChecked(): MutableList<TaskToDo> {
        toDoList.sortWith(compareBy<TaskToDo> { it.isCheck }.thenBy { it.name })
        return mutableListOf<TaskToDo>().apply { addAll(toDoList) }
    }

    private fun sortingMethod(): MutableList<TaskToDo> {

        return when (sortingSelection) {

            SortingSelectionEnum.BYNAME.ordinal -> {
                sortToDoListByTaskNames()
            }
            SortingSelectionEnum.BYCHECKEDTHENBYNAME.ordinal -> {
                sortToDoListByTaskChecked()
            }
            else -> {
                mutableListOf<TaskToDo>()
            }

        }

    }

    // j'ai passe les methodes de sorting en private et je les utilise en mode implicite dans les fonctions add et remove
    // je rajoute un selecteur pour permettre de choisir le sorting par Name ou par isChecked puis Name comme ca on utilise le sorting en implicite
    // j'ai refactorise Index en Id pour un langage metier

}