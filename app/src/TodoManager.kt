package np.com.bimalkafle.todoapp

import java.time.Instant
import java.util.Date

// Singleton object responsible for managing Todo items
object TodoManager {

    // Mutable list to store Todo items
    private val todoList = mutableListOf(
        Todo(1, "Upstairs carpet needs to be replaced", Date.from(Instant.now()))
    )

    // Function to retrieve all Todo items
    fun getAllTodo() : List<Todo>{
        return todoList
    }

    // Function to add a new Todo item
    fun addTodo(title : String){
        // Generate a unique id for the new Todo item based on current system time
        val id = System.currentTimeMillis().toInt()
        // Create a new Todo item and add it to the list
        todoList.add(Todo(id, title, Date.from(Instant.now())))
    }

    // Function to delete a Todo item by its id
    fun deleteTodo(id : Int){
        // Remove the Todo item from the list if its id matches the provided id
        todoList.removeIf{
            it.id == id
        }
    }

}
