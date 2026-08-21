package com.radwan.nova.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.radwan.nova.data.repository.ChatRepository
import com.radwan.nova.data.repository.MessageDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatViewModel(
    private val repository: ChatRepository = ChatRepository()
) : ViewModel() {

    private val _messages = MutableStateFlow<List<MessageDto>>(emptyList())
    val messages: StateFlow<List<MessageDto>> = _messages

    fun loadMessages(chatId: String) {
        viewModelScope.launch {
            repository.getMessagesFlow(chatId).collect { messageList ->
                _messages.value = messageList
            }
        }
    }

    fun sendMessage(chatId: String, senderId: String, content: String) {
        if (content.isBlank()) return
        viewModelScope.launch {
            try {
                repository.sendMessage(chatId, senderId, content)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
