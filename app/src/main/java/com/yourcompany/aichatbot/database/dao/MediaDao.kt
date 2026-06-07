package com.yourcompany.aichatbot.database.dao

import androidx.room.*
import com.yourcompany.aichatbot.models.MediaItem
import kotlinx.coroutines.flow.Flow

@Dao
interface MediaDao {
    @Insert
    suspend fun insert(mediaItem: MediaItem): Long

    @Update
    suspend fun update(mediaItem: MediaItem)

    @Delete
    suspend fun delete(mediaItem: MediaItem)

    @Query("SELECT * FROM media_items WHERE id = :id")
    suspend fun getMediaById(id: Long): MediaItem?

    @Query("SELECT * FROM media_items WHERE sessionId = :sessionId ORDER BY savedAt DESC")
    fun getMediaForSession(sessionId: Long): Flow<List<MediaItem>>

    @Query("SELECT * FROM media_items ORDER BY savedAt DESC")
    fun getAllMedia(): Flow<List<MediaItem>>

    @Query("DELETE FROM media_items WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM media_items WHERE sessionId = :sessionId")
    suspend fun deleteMediaForSession(sessionId: Long)
}
