package com.mobile.boriandmallory.boriandmalloryweddingandroid.models

data class Seating(
        val name: String,
        val table: String
)

public class SeatingResponse(
    val response: List<Seating>
)

public class SeatingResponseFromAPI(
        val data: SeatingResponse
)