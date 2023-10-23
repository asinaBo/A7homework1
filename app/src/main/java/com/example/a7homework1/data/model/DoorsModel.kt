package com.example.a7homework1.data.model

data class DoorsModel(
    val `data`: List<Data>,
    val success: Boolean
) {
    data class Data(
        val favorites: Boolean,
        val id: Int,
        val name: String,
        val room: String,
        val snapshot: String
    )
}