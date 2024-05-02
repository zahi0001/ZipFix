package np.com.bimalkafle.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// ViewModel class responsible for managing Todo-related data and interactions
class TodoViewModel : ViewModel() {

    // LiveData for storing the list of Todo items
    private var _todoList = MutableLiveData<List<Todo>>()
    val todoList : LiveData<List<Todo>> = _todoList

    // Initialize the ViewModel by loading all Todo items
    init {
        getAllTodo()
    }

    // Function to fetch all Todo items and update the LiveData
    fun getAllTodo(){
        _todoList.value = TodoManager.getAllTodo().reversed()
    }

    // Function to add a new Todo item
    fun addTodo(title : String){
        // Add the new Todo item using the TodoManager
        TodoManager.addTodo(title)
        // Refresh the list of Todo items
        getAllTodo()
    }

    // Function to delete a Todo item by its id
    fun deleteTodo(id : Int){
        // Delete the Todo item using the TodoManager
        TodoManager.deleteTodo(id)
        // Refresh the list of Todo items
        getAllTodo()
    }

}
