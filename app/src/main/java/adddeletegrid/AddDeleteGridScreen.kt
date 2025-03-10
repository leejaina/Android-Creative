package adddeletegrid

import adddelete.AddDeleteScreen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavHost
import androidx.compose.runtime.remember
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import adddelete.NumberCircle

@Preview
@Composable //이동 버튼 컴포저블
fun MoveButton(onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(width = 100.dp, height = 40.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xFFFFA938)
        )
    ) {
        Text("이동", color = Color.Black)
    }
}

@Composable
fun NewAddDeleteScreen(onMoveClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AddDeleteScreen()
        Spacer(modifier = Modifier.height(22.dp))
        MoveButton(onClick = onMoveClick) // ✅ 이동 버튼 추가
    }
}


@Composable
fun AddDeleteGridScreen(onMoveClick: () -> Unit) {
    var numbers by remember { mutableStateOf((1..3).toList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 81.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(numbers) { number ->
                NumberCircle(number = number)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MoveButton(onClick = onMoveClick)
            Spacer(modifier = Modifier.height(22.dp))

            Button(
                onClick = {
                    if (numbers.size > 1) numbers = numbers.dropLast(1)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEADDFF))
            ) {
                Text("삭제", color = Color.Black)
            }

            Button(
                onClick = {
                    if (numbers.size < 15) numbers = numbers + (numbers.size + 1)
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF66558F))
            ) {
                Text("추가", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddDeleteGridScreenPreview() {
    AddDeleteGridScreen(onMoveClick = {})
}

@Preview(showBackground = true)
@Composable
fun NewAddDeleteScreenPreview() {
    NewAddDeleteScreen(onMoveClick = {})
}

