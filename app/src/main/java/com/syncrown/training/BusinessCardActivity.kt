package com.syncrown.training

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.syncrown.training.ui.theme.AndroidGreen
import com.syncrown.training.ui.theme.TrainingTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.getInsetsController(window, window.decorView).let {insetController ->
            insetController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            insetController.hide(WindowInsetsCompat.Type.systemBars())
        }
        setContent {
            TrainingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposableBusinessCard()
                }
            }
        }
    }


    @Composable
    fun ComposableBusinessCard() {

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 36.dp)
                    .weight(2f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,

            ) {
                BusinessCardTitle(
                    image = painterResource(id = R.drawable.ic_task_completed),
                    title = "CHOI IN HYEOK",
                    content = "Android Junior Developer",
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            ) {
                BusinessCardContent(
                    phoneNumber = "+82 10 - 8924 - 0922",
                    share = "@AndroidDev",
                    email = "book3039@knou.ac.kr"
                )
            }
        }
    }


    @Composable
    fun BusinessCardTitle(
        image: Painter,
        title: String,
        content: String,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = null,

            )
            
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                fontFamily = FontFamily.Monospace,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = content,
                fontSize = 18.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = AndroidGreen,
            )
        }
    }

    @Composable
    fun BusinessCardContent(
        phoneNumber: String,
        share: String,
        email: String
    ) {
        Column {
            Row {
                Icon(
                    imageVector =  Icons.Default.Call,
                    tint = AndroidGreen,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = phoneNumber,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Icon(
                    imageVector =  Icons.Default.Share,
                    tint = AndroidGreen,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = share,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Icon(
                    imageVector =  Icons.Default.Email,
                    tint = AndroidGreen,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = email,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BusinessCardPreview() {
        TrainingTheme {
            ComposableBusinessCard()
        }
    }
}



