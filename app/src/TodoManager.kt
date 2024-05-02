package np.com.bimalkafle.todoapp

import java.time.Instant
import java.util.Date

object TodoManager {

    private val todoList = mutableListOf(
        Todo(1, "Upstairs carpet needs to be replaced", Date.from(Instant.now()))
    )


    fun getAllTodo() : List<Todo>{
        return todoList
    }

    fun addTodo(title : String){
        todoList.add(Todo(System.currentTimeMillis().toInt(),title, Date.from(Instant.now())))
    }

    fun deleteTodo(id : Int){
        todoList.removeIf{
            it.id==id
        }
    }

}