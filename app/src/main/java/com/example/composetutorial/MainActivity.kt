package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.model.Message
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

val message = listOf(
    Message("Android", "Jetpack Compose"),
    Message("Ram", "hii how are you"),
    Message("Sam", "All Good What about you dgbshgdajkdasn bkjasdbnfda dabdjkandm,a cadcbnjkandcm, amc a bcka ndca nc a xca cabnckacakcacba "),
    Message("Android", "Jetpack Compose bdkjakdna ck ac k ncka ck k ck kk cka ck nkcj, c kk k kd "),
    Message("Sumitra", "Hiiii all Good"),
    Message("Android", "Jetpack Compose"),
    Message("Android", "Jetpack Compose ckc s ckd nsakc d dckj nkda c ckak  ks ksk ks  cksk k k"),
    Message("Android", "Jetpack Compose  s kskcn kjds c sk  sks  s sv c sv  sdv fs  sv v"),
    Message("Android", "Jetpack Compose  cvfgbgn ui jyutyu ymik uiewyg5yiejhmnh erty grtu6sd "),
    Message("Android", "Jetpack Compose dg ety5syr6rts yrt yr utiuawteyyui  6r4 t ty"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            ComposeTutorialTheme {
                Conversations(message)
            }
        }
    }
}

@Composable
fun Greeting(name: String, message: String) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Content Profile Picture",
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)
                .align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.width(8.dp))
        var isExpanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }){
            Text(
                text = name,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleSmall,
            )

            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = message,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun GreetingPreview() {
    ComposeTutorialTheme {
        Conversations(message = message)
    }
}

@Composable
fun Conversations(message: List<Message>) {
    LazyColumn {
        items(message) { message ->
            Greeting(message.name, message.message)
        }
    }
}