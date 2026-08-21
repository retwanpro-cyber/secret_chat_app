package com.radwan.nova.data.repository

import com.radwan.nova.data.remote.SupabaseClientProvider
import io.github.jan_tennert.supabase.postgrest.from
import io.github.jan_tennert.supabase.realtime.selectAsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable

@Serializable
data class MessageDto(
    val id: String? = null,
    val chat_id: String,
    val sender_id: String,
    val content: String,
    val created_at: String? = null
)

class ChatRepository {
    private val client = SupabaseClientProvider.client

    // إرسال رسالة جديدة
    suspend fun sendMessage(chatId: String, senderId: String, content: String) {
        val message = MessageDto(chat_id = chatId, sender_id = senderId, content = content)
        client.from("messages").insert(message)
    }

    // استقبال الرسائل فورياً
    fun getMessagesFlow(chatId: String): Flow<List<MessageDto>> {
        return client.from("messages")
            .selectAsFlow(MessageDto::id)
    }
}
