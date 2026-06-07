package com.yourcompany.aichatbot.database.dao

import androidx.room.*
import com.yourcompany.aichatbot.models.Character
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    @Insert
    suspend fun insert(character: Character): Long

    @Update
    suspend fun update(character: Character)

    @Delete
    suspend fun delete(character: Character)

    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getCharacterById(id: Long): Character?

    @Query("SELECT * FROM characters ORDER BY createdAt DESC")
    fun getAllCharacters(): Flow<List<Character>>

    @Query("DELETE FROM characters WHERE id = :id")
    suspend fun deleteById(id: Long)
}
