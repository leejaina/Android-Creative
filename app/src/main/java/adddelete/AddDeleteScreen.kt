package adddelete

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable //숫자 똥그라미 컴포저블
fun NumberCircle(number: Int=1) { //와 미친~ 프리뷰쓰려면 변수의 기본값을 정해야한다고??
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
fun RemoveButton(onClick: () -> Unit={}) { //지피띠가 이렇게 하래용(잘 이해못함
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xFFEADDFF)
        )
    ) {
        Text("삭제", color = Color.Black)
    }
}

@Preview
@Composable //추가 버튼 컴포저블
fun AddButton(onClick: () -> Unit={}) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xFF66558F)
        )
    ) {
        Text("추가", color = Color.White)
    }
}