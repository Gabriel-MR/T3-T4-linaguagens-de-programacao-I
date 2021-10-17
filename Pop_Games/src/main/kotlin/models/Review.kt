package models

import java.util.*

data class Review(
    val idReview: Int,
    val review: String,
    val curtidas: String,
    val data: Date,
    val idElemento: Int,
    val login: String
)
