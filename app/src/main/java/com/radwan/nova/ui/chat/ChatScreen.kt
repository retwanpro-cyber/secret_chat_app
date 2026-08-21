package com.radwan.nova.ui.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChatScreen(viewModel: ChatViewModel = ChatViewModel(), chatId: String, currentUserId: String) {
    val messages by viewModel.messages.collectAsState()
    var text by remember { mutableStateOf("") }

    // تحميل الرسائل عند فتح الشاشة
    LaunchedEffect(chatId) {
        viewModel.loadMessages(chatId)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // عرض قائمة الرسائل
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(messages) { message ->
                Card(modifier = Modifier.padding(4.dp).fillMaxWidth()) {
                    Text(text = message.content, modifier = Modifier.padding(8.dp))
                }
            }
        }

        // خانة الكتابة وزر الإرسال
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("اكتب رسالة...") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                viewModel.sendMessage(chatId, currentUserId, text)
                text = "" // تفريغ خانة النص بعد الإرسال
            }) {
                Text("إرسال")
            }
        }
    }
}
