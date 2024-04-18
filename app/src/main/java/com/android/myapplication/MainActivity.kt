package com.android.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.myapplication.ui.theme.MyApplicationTheme
import com.android.myapplication.ui.theme.Pink40
import com.android.myapplication.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
//        modifier = modifier,
        modifier = Modifier.padding(10.dp, 100.dp, 20.dp, 50.dp)
    )

    Text(
        text = "欢迎使用xx管理系统",
        fontSize = 20.sp,
        color = Purple40,
        modifier = Modifier.padding(20.dp, 50.dp, 0.dp, 60.dp)
    )

    BasicTextField(
        value = name,
        onValueChange = {
            //name = it
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(10.dp, 0.dp, 0.dp, 0.dp),
        textStyle = TextStyle(
            color = Pink40
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = 10.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                if (name.isEmpty()) {
                    Text(
                        text = "请输入用户名或密码",
                        fontSize = 12.sp,
                        color = Pink40,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                innerTextField()
            }
        },
    )

    ClickableText(text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Purple40, fontSize = 14.sp)) {
            append("短信验证码登录")
        }
    }, onClick = {
        Log.d("xxx", "你已经点到 短信验证码登录")
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}