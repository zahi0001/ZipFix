package np.com.bimalkafle.todoapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale

// Composable function representing the TodoListPage
@Composable
fun TodoListPage(viewModel: TodoViewModel){

    // Retrieve the todoList from the ViewModel and observe its state
    val todoList by viewModel.todoList.observeAsState()
    // State variable to hold the input text for adding new todos
    var inputText by remember {
        mutableStateOf("")
    }

    // Column composable to structure the UI vertically
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {

        // Row composable for input field and add button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Input field for entering new todo text
            OutlinedTextField(
                modifier= Modifier.weight(1f),
                value = inputText,
                onValueChange = {
                    inputText = it
                })
            // Button to add new todo
            Button(onClick = {
                viewModel.addTodo(inputText)
                inputText = ""
            }) {
                Text(text = "Add")
            }
        }

        // LazyColumn to display the list of todos
        todoList?.let {
            LazyColumn(
                content = {
                    // Iterate through todoList and display each todo item
                    itemsIndexed(it){ index: Int, item: Todo ->
                        TodoItem(item = item, onDelete = {
                            viewModel.deleteTodo(item.id)
                        })
                    }
                }
            )
        }?: Text(
            // Displayed when todoList is null or empty
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "No items yet",
            fontSize = 16.sp
        )
    }
}

// Composable function representing a single Todo item
@Composable
fun TodoItem(item : Todo,onDelete : ()-> Unit) {
    // Row composable to structure the todo item horizontally
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Column composable to structure the content of the todo item vertically
        Column(
            modifier = Modifier.weight(1f)
        ) {
            // Display the creation date of the todo item
            Text(
                text = SimpleDateFormat("HH:mm:aa, dd/mm", Locale.ENGLISH).format(item.createdAt),
                fontSize = 12.sp,
                color = Color.LightGray
            )
            // Display the title of the todo item
            Text(
                text = item.title,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        // IconButton for deleting the todo item
        IconButton(onClick = onDelete) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete",
                tint = Color.White
            )
        }
    }
}
