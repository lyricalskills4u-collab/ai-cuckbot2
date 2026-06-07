package com.yourcompany.aichatbot.database.dao

import androidx.room.*
import com.yourcompany.aichatbot.models.Message
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {
    @Insert
    suspend fun insert(message: Message): Long

    @Update
    suspend fun update(message: Message)

    @Delete
    suspend fun delete(message: Message)

    @Query("SELECT * FROM messages WHERE id = :id")
    suspend fun getMessageById(id: Long): Message?

    @Query("SELECT * FROM messages WHERE sessionId = :sessionId ORDER BY timestamp ASC")
    fun getMessagesForSession(sessionId: Long): Flow<List<Message>>

    @Query("SELECT * FROM messages WHERE sessionId = :sessionId AND messageType != 'text' ORDER BY timestamp DESC")
    fun getMediaMessages(sessionId: Long): Flow<List<Message>>

    @Query("DELETE FROM messages WHERE sessionId = :sessionId")
    suspend fun deleteMessagesForSession(sessionId: Long)

    @Query("DELETE FROM messages WHERE id = :id")
    suspend fun deleteById(id: Long)
}
