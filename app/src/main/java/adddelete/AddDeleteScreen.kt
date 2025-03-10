package adddelete

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Preview
@Composable //숫자 똥그라미 컴포저블
fun NumberCircle(number: Int = 1) { //와 미친~ 프리뷰쓰려면 변수의 기본값을 정해야한다고??
    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape) //RoundCornerShape(100.dp) 랑 또캍음
            .background(Color(0xFFFAB398)),
        contentAlignment = Center
    ) {
        Text(
            text = number.toString(),
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Preview
@Composable //삭제 버튼 컴포저블
fun RemoveButton(onClick: () -> Unit = {}) { //지피띠가 이렇게 하래용
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(width = 100.dp, height = 40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFEADDFF)
        )
    ) {
        Text("삭제", color = Color.Black)
    }

}

@Preview
@Composable //추가 버튼 컴포저블
fun AddButton(onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(width = 100.dp, height = 40.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xFF66558F)
        )
    ) {
        Text("추가", color = Color.White)
    }
}


@Composable //걍 전체 화면 컴포저블
fun AddDeleteScreen() {
    var numbers by remember { mutableStateOf(listOf(1)) } //numbers=[1] 이라는 리스트 만들어져
    //val 로 어떻게 써야할지 모르겠어요 ㅠㅠ

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 81.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f) //컴포넌트가 부모 Column이나 Row같은데서 비율 어케차지할지
                .fillMaxWidth()
                .padding(start = 30.dp, top = 30.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(numbers.size) { index ->
                NumberCircle(number=numbers[index])
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 60.dp, end = 60.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RemoveButton {
                if (numbers.size > 1) {
                    numbers = numbers.dropLast(1)
                }
            }

            Spacer(modifier = Modifier.width(40.dp))

            AddButton {
                if (numbers.size < 6) {
                    numbers = numbers + (numbers.size + 1)
                }
            }
        }
    }
}

@Preview (showBackground = true,  )
@Composable
private fun AddDeleteScreenPreview () {
    AddDeleteScreen()
}