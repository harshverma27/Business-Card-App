package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CreateBizCard()
                }
            }
        }
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun CreateBizCard(){
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .background(color = Color(116, 179, 206))
            .padding(10.dp, 30.dp, 10.dp, 15.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(20.dp)){
            Column(modifier = Modifier.background(color = Color(80, 137, 145)),
                horizontalAlignment = (Alignment.CenterHorizontally)) {

                CreateProfileImage(modifier = Modifier)
                Divider(
                    thickness = 5.dp,
                    color = Color(64, 50, 51),
                    modifier = Modifier.padding(25.dp, 5.dp, 25.dp, 5.dp)
                )
                CreateText(modifier = Modifier)
                Card(modifier = Modifier
                    .width(360.dp)
                    .height(480.dp)
                    .background(color = Color(80, 137, 145))
                    .padding(5.dp),
                    shape = RoundedCornerShape(corner = CornerSize((15.dp))),
                    elevation = CardDefaults.cardElevation(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(65, 66, 136))
                ) {
                    Column(modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(5.dp, 10.dp, 5.dp, 10.dp),
                        horizontalAlignment =Alignment.CenterHorizontally) {
                        Button(
                            onClick = {
                                buttonClickedState.value = !buttonClickedState.value
                            }
                        ) {
                            Text(text = "Portfolio",
                                modifier = Modifier,
                                fontSize = 15.sp
                            )
                        }
                        Divider(thickness = 5.dp, modifier = Modifier.padding(8.dp,5.dp,8.dp,5.dp), color = Color(241, 154, 62))
                        if (buttonClickedState.value){
                            Content()
                        }
                    }

                }
            }
        }
    }
}
@Composable
fun CreateProfileImage(modifier: Modifier){
    Surface(modifier = Modifier
        .size(120.dp)
        .padding(15.dp, 25.dp, 15.dp, 5.dp),
        shape = CircleShape,
        border = BorderStroke(3.dp, Color(65, 66, 136)),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ){
        Image(painter = painterResource(id = R.drawable.pfp), contentDescription = "")
    }
}

@Composable
fun CreateText(modifier: Modifier){
    Column {
        Text(text = "Harsh Verma", color = Color(222, 239, 183), fontSize = 25.sp)
    }
    Divider(thickness = 5.dp, modifier = Modifier.padding(8.dp, 5.dp, 8.dp, 5.dp), color = Color(241, 154, 62))
    Column {
        Text(text = "Udaipur, Rajasthan", color = Color(222, 239, 183))
    }
    Divider(thickness = 5.dp, modifier = Modifier.padding(8.dp, 5.dp, 8.dp, 5.dp), color=Color(241, 154, 62))
    Column {
        Text(text = "B.Tech, NIT Hamirpur", color = Color(222, 239, 183))
    }
    Divider(thickness = 5.dp, modifier = Modifier.padding(8.dp, 5.dp, 8.dp, 5.dp), color=Color(241, 154, 62))
    Column {
        Text(text = "C++ | Python | Kotlin | Bash | SQL | Jetpack", color = Color(222, 239, 183))
    }
    Divider(thickness = 5.dp, modifier = Modifier.padding(8.dp, 5.dp, 8.dp, 5.dp), color=Color(241, 154, 62))
    Column {
        Text(text = "Git | GitHub | Linux | ", color = Color(222, 239, 183))
    }
    Divider(thickness = 5.dp, modifier = Modifier.padding(8.dp, 5.dp, 8.dp, 5.dp), color=Color(241, 154, 62))

}
@Preview(showBackground = true)
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp))    {
        Surface(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            border = BorderStroke(width=2.dp,color = Color(0, 20, 39)),
                    color = Color(175, 56, 0)
        )
            {
            Portfolio(data = listOf(
                Project(1,"Name1","Description1"),
                Project(2,"Name2","Description2"),
                Project(3,"Name3","Description3"),
                Project(4,"Name4","Description4"),
                Project(5,"Name5","Description5"),
                Project(6,"Name6","Description6"),
                Project(7,"Name7","Description7"),
                Project(8,"Name8","Description8"),
                Project(9,"Name9","Description9"),
                Project(10,"Name10","Description10")
                )
            )
                
        }
    }
}
data class Project(val id: Int,val name: String, val description: String)

@Composable
fun Portfolio(data: List<Project>) {
    LazyColumn {
        items(data) { item ->
            Card(modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(5.dp)){
                Row(modifier = Modifier
                    .padding(3.dp)
                    .fillMaxWidth()
                    .background(color = Color.Black)) {
                    Surface(modifier = Modifier
                        .width(50.dp)
                        .fillMaxHeight()
                        .padding(1.dp, 1.25.dp, 0.dp, 0.dp),
                        shape = RectangleShape,
                        border = BorderStroke(1.dp,Color.Black)
                    ) {
                        Box(modifier = Modifier, contentAlignment = Alignment.Center){
                            Text(text = item.id.toString(), modifier = Modifier.padding(2.dp), textAlign = TextAlign.Center, fontSize = 35.sp)
                        }

                    }
                    Surface(modifier = Modifier
                        .fillMaxHeight()
                        .width(178.dp)
                        .padding(2.dp)
                        .size(50.dp), color = Color.LightGray){
                        Column(modifier = Modifier.align(alignment = Alignment.CenterVertically), horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = item.name, modifier = Modifier, color = Color.Black, fontWeight = FontWeight.Bold)
                            Text(text = item.description, modifier = Modifier, color = Color.Black, style = MaterialTheme.typography.bodySmall)
                        }

                    }
                    Surface(modifier = Modifier
                        .size(50.dp)
                        .padding(0.dp, 3.dp, 2.dp, 0.dp)
                        .fillMaxHeight(), shape = CircleShape, border = BorderStroke(1.0.dp,Color.Red)) {
                        Image(painter = painterResource(R.drawable.code), contentDescription = "")

                    }
                }

            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        CreateBizCard()
    }
}