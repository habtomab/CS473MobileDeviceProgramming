package com.example.cs473mobiledeviceprogramming.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class QuizModel(
    @SerializedName("question")
    val qutn: String,
    @SerializedName("answer1")
    val ans1: String,
    @SerializedName("answer2")
    val ans2: String,
    @SerializedName("answer3")
    val anse3: String,
    @SerializedName("correctAnswer")
    val crectAns: Int
) : Serializable
