package com.yourcompany.aichatbot.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yourcompany.aichatbot.database.dao.*
import com.yourcompany.aichatbot.models.*

@Database(
    entities = [
        Character::class,
        Message::class,
        ChatSession::class,
        MediaItem::class,
        AppSettings::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun messageDao(): MessageDao
    abstract fun chatSessionDao(): ChatSessionDao
    abstract fun mediaDao(): MediaDao
    abstract fun settingsDao(): SettingsDao

    companion object {
        const val DATABASE_NAME = "ai_chatbot_db"
    }
}
