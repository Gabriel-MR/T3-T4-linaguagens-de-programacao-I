package models

import java.sql.Date
import java.util.*

data class Review(
    val id: Int,
    val review: String,
    val data: Date,
    val login: String,
    val idElemento: Int
)
