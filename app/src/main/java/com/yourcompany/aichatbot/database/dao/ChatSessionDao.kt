package com.yourcompany.aichatbot.database.dao

import androidx.room.*
import com.yourcompany.aichatbot.models.ChatSession
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatSessionDao {
    @Insert
    suspend fun insert(chatSession: ChatSession): Long

    @Update
    suspend fun update(chatSession: ChatSession)

    @Delete
    suspend fun delete(chatSession: ChatSession)

    @Query("SELECT * FROM chat_sessions WHERE id = :id")
    suspend fun getSessionById(id: Long): ChatSession?

    @Query("SELECT * FROM chat_sessions WHERE characterId = :characterId ORDER BY updatedAt DESC")
    fun getSessionsForCharacter(characterId: Long): Flow<List<ChatSession>>

    @Query("SELECT * FROM chat_sessions ORDER BY updatedAt DESC")
    fun getAllSessions(): Flow<List<ChatSession>>

    @Query("DELETE FROM chat_sessions WHERE id = :id")
    suspend fun deleteById(id: Long)
}
