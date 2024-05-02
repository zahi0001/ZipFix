package np.com.bimalkafle.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import np.com.bimalkafle.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize ViewModel for managing Todo data
        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        
        // Set the content of the activity using Jetpack Compose
        setContent {
            // Apply the custom theme to the entire app
            TodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Display the Todo list page, passing the ViewModel
                    TodoListPage(todoViewModel)
                }
            }
        }
    }
}