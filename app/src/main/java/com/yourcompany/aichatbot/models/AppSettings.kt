package com.yourcompany.aichatbot.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_settings")
data class AppSettings(
    @PrimaryKey
    val id: Int = 1,
    val allowNSFW: Boolean = true,
    val imageQuality: String = "high",
    val autoSave: Boolean = true,
    val lastSessionId: Long? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
