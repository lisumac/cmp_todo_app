package org.rdk.todo.presentaion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.rdk.todo.utill.Resource

@Composable
fun InfoCard(
    message: String,
    containterColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.surface,
    lightModeIcon: DrawableResource = Resource.Image.PAINTING_LIGHT,
    darkModeIcon: DrawableResource = Resource.Image.PAINTING_DARK
) {
    Column(
        modifier = Modifier.fillMaxSize().background(containterColor).padding(8.dp),
        Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(resource = if (isSystemInDarkTheme()) darkModeIcon else lightModeIcon),
            modifier = Modifier.size(8.dp),
            contentDescription = null


        )
        Spacer(Modifier.height(8.dp))

        Text(text = message, color = MaterialTheme.colorScheme.onSurface)
    }
}

@Preview()
@Composable()
fun infoCardPreview(){
    InfoCard(message = "Empty message")

}
