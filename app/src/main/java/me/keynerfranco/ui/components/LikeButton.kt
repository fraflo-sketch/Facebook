package me.keynerfranco.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LikeButton(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    text: String = "Me gusta",
    onClick: () -> Unit = {}
) {
    val buttonColor = if (isLiked) Color(0xFF1877F2) else Color.Gray

    Row(
        modifier = modifier
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ícono del pulgar arriba a la izquierda
        Icon(
            imageVector = Icons.Default.ThumbUp,
            contentDescription = "Me gusta",
            modifier = Modifier.size(20.dp),
            tint = buttonColor
        )

        Spacer(modifier = Modifier.width(6.dp))

        // Texto a la derecha
        Text(
            text = text,
            color = buttonColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LikeButtonPreview() {
    LikeButton()
}

@Preview(showBackground = true)
@Composable
fun LikeButtonLikedPreview() {
    LikeButton(isLiked = true)
}
