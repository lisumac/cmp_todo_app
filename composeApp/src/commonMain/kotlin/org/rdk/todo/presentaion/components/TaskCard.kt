package org.rdk.todo.presentaion.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.rdk.todo.domain.Priority
import org.rdk.todo.domain.ToDoTask
import org.rdk.todo.utill.Alpha

@Composable()
fun TaskCard(modifier: Modifier = Modifier, task: ToDoTask, onclick: (String) -> Unit) {
    Card(
        Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).clickable {
            onclick(task.id)
        },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Top
        ) {

            Column() {
                Text(
                    modifier = Modifier.alpha(if (task.isCompleted) Alpha.HALF else Alpha.FULL),

                    text = task.title, style = TextStyle(fontWeight = FontWeight.Medium),
                    textDecoration = if (task.isCompleted) TextDecoration.LineThrough else TextDecoration.None,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (task.description.isNotEmpty())
                    Text(
                        modifier = Modifier.alpha(if (task.isCompleted) Alpha.HALF else Alpha.FULL),
                        text = task.description,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
            }
        }
        PriorityChip(priority = task.priority , isCompleted = true)

    }

}

@Preview()
@Composable()
fun TaskCardPreview() {
    TaskCard(
        task = ToDoTask(
            title = "Example Title,",
            description = "RandomText",
            isCompleted = true,
            priority = Priority.Low

        ), onclick = {})
}

@Preview()
@Composable()
fun TaskCardNotCompletedPreview() {
    TaskCard(
        task = ToDoTask(
            title = "Example Title,",
            description = "RandomText",
            isCompleted = false,
            priority = Priority.Low

        ), onclick = {})
}
