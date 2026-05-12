package com.example.bibliounifor.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliounifor.ui.theme.BiblioCyan

@Composable
fun BiblioHeader(title: String, userEmail: String? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(BiblioCyan)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = Color.White.copy(alpha = 0.2f), radius = size.width * 0.4f, center = Offset(0f, 0f))
            drawCircle(color = Color.White.copy(alpha = 0.1f), radius = size.width * 0.3f, center = Offset(size.width * 0.3f, size.width * 0.2f))
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(onClick = {}) { Icon(Icons.Default.Notifications, contentDescription = null) }
                Box(modifier = Modifier.size(70.dp).clip(CircleShape).background(Color.Gray))
                IconButton(onClick = {}) { Icon(Icons.Default.Settings, contentDescription = null) }
            }
            if (userEmail != null) {
                Text(text = userEmail, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}