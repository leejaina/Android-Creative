package profilecard

import com.example.androidcreative.R

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcreative.ui.theme.AndroidCreativeTheme

@Preview
@Composable //하나의 학생증을 만드는 컴포저블
fun ProfileCardComponent() {
    Box( //학생증 틀
        modifier = Modifier
            .height(80.dp)
            .width(160.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image( //학생증 배경
            painter = painterResource(id = R.drawable.studentcard),
            contentDescription = "학생증 틀",
            modifier = Modifier.fillMaxSize()
        )

        Box( // 프로필 내용 & 프사 틀
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .height(43.dp)
                .width(116.dp),
            contentAlignment = Alignment.CenterStart // 내부 요소 왼쪽 정렬
        ) {
            Row( // 프사와 텍스트 가로 정렬
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box( // 프사 틀
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profilepic),
                        contentDescription = "프사",
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(10.dp)) // 프사와 텍 사이 여백

                Column( // 프로필 정보
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(text = "이름 : 이재인", fontSize = 8.sp)
                    Text(text = "학번 : 202410801", fontSize = 8.sp)
                    Text(text = "학과 : 기로자공학부", fontSize = 8.sp)
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(horizontal = 11.dp, vertical = 8.dp)
        ) {
            ProfileCardButton()
        }
    }
}

@Preview
@Composable
fun ProfileCardButton( //버튼 기능을 위한 컴포저블
    modifier: Modifier = Modifier
) {
    var isClicked by rememberSaveable { mutableStateOf(false) }

    Image(
        painter = painterResource(
            id = if (isClicked) R.drawable.blackbotton
            else R.drawable.redbotton
        ),
        contentDescription = "버튼",
        modifier = modifier
            .size(15.dp)
            .clickable { isClicked = !isClicked }
    )
}

@Preview
@Composable //전체 화면 구성. mainactivity와 이어진다.
fun ProfileCardScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(top = 11.dp, start = 13.dp)
    ) {
        items(7) {
            ProfileCardComponent()
        }
    }
}