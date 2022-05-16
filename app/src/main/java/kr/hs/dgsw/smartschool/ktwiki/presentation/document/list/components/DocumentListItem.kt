package kr.hs.dgsw.smartschool.ktwiki.presentation.document.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.ktwiki.domain.model.Document

@Composable
fun DocumentListItem (
    document: Document,
    onItemClick: (Document) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(document) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = document.title,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "조회수 : ${document.hits}",
            color = Color.Blue,
            style = MaterialTheme.typography.body2,
        )
    }
}