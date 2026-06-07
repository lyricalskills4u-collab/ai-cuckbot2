package com.yourcompany.aichatbot.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String = "",
    val age: Int = 0,
    val hairColor: String = "",
    val skinTone: String = "",
    val bodyType: String = "",
    val breastSize: String = "", // for female characters
    val assSize: String = "", // for female characters
    val cockSize: String = "", // for male characters
    val personality: String = "",
    val interests: String = "", // comma-separated list
    val avatarPath: String? = null,
    val isNSFW: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
