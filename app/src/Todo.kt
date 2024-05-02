package np.com.bimalkafle.todoapp

import java.time.Instant
import java.util.Date

// Data class representing a Todo item with an id, title, and creation date
data class Todo(
    var id: Int,
    var title : String,
    var createdAt : Date
)

// Function to generate fake Todo items for testing or demonstration purposes
fun getFakeTodo() : List<Todo>{
    // Return a list of Todo objects with fake data
    return listOf<Todo>(
        Todo(1,"First todo ",Date.from(Instant.now())),
        Todo(2,"Second todo ",Date.from(Instant.now())),
        Todo(3,"this is my third todo ",Date.from(Instant.now())),
        Todo(4,"this will be my forth todo ",Date.from(Instant.now()))
    );
}
