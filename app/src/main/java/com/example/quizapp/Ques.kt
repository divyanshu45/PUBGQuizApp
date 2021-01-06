package com.example.quizapp

data class Ques(
    val id: Int,
    val question: String,
    val image: Int,
    val hasSound: Boolean,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctOption: Int
)