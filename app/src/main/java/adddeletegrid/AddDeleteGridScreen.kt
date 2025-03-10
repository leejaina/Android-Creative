package adddeletegrid

import adddelete.AddButton
import adddelete.AddDeleteScreen
import adddelete.NumberCircle
import adddelete.RemoveButton
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MoveButton(onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(width = 100.dp, height = 40.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA938))
    ) {
        Text("이동", color = Color.Black)
    }
}

@Composable
fun NewVerAddDeleteScreen(onMoveClick: (List<Int>) -> Unit, numbers: List<Int>) {
    var numbersState by rememberSaveable { mutableStateOf(numbers.take(6)) }

    Column(
        modifier = Modifier.fillMaxSize().padding(bottom = 81.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(start = 30.dp, top = 30.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(numbersState) { number ->
                NumberCircle(number = number)
            }
        }

        MoveButton { onMoveClick(numbersState) } // 이동 버튼을 위쪽에 배치

        Spacer(modifier = Modifier.height(22.dp)) // 버튼 사이 공간 조정

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RemoveButton {
                if (numbersState.size > 1) {
                    numbersState = numbersState.dropLast(1)
                }
            }

            AddButton {
                if (numbersState.size < 6) {
                    numbersState = numbersState + (numbersState.size + 1)
                }
            }
        }
    }
}

@Composable
fun AddDeleteGridScreen(onMoveClick: (List<Int>) -> Unit, numbers: List<Int>) {
    var numbersState by rememberSaveable { mutableStateOf(numbers) }

    Column(
        modifier = Modifier.fillMaxSize().padding(bottom = 81.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(start = 30.dp, top = 30.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(numbersState) { number ->
                NumberCircle(number = number)
            }
        }

        MoveButton { onMoveClick(numbersState) } // 이동 버튼

        Spacer(modifier = Modifier.height(22.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (numbersState.size > 1) numbersState = numbersState.dropLast(1)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEADDFF))
            ) {
                Text("삭제", color = Color.Black)
            }

            Button(
                onClick = {
                    if (numbersState.size < 15) numbersState = numbersState + (numbersState.size + 1)
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF66558F))
            ) {
                Text("추가", color = Color.White)
            }
        }
    }
}

@Composable
fun AddDeleteGridNavGraph() {
    val navController = rememberNavController()
    var numbers by rememberSaveable { mutableStateOf(listOf(1)) }

    NavHost(navController = navController, startDestination = "new_add_delete") {
        composable("new_add_delete") {
            NewVerAddDeleteScreen(
                onMoveClick = { updatedNumbers ->
                    numbers = updatedNumbers // 상태 저장
                    navController.navigate("add_delete_grid")
                },
                numbers = numbers
            )
        }
        composable("add_delete_grid") {
            AddDeleteGridScreen(
                onMoveClick = { updatedNumbers ->
                    numbers = updatedNumbers.take(6) // 6개 초과 시 제한
                    navController.popBackStack()
                },
                numbers = numbers
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddDeleteGridScreenPreview() {
    AddDeleteGridScreen(
        onMoveClick = {},
        numbers = listOf(1, 2, 3)
    )
}

@Preview(showBackground = true)
@Composable
fun NewVerAddDeleteScreenPreview() {
    NewVerAddDeleteScreen(
        onMoveClick = {},
        numbers = listOf(1, 2, 3)
    )
}