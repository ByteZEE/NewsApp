package com.rafi.core.resources.local.entity


import com.google.gson.annotations.SerializedName

data class SourceEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)