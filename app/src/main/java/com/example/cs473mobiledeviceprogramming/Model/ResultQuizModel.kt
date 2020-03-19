package com.example.cs473mobiledeviceprogramming.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class ResultQuizModel(
    val question: String,
    val SelectAns:String,
    val corectAns:String) : Parcelable {

    constructor(quiz: QuizModel, selectedAnswer: String) : this(
        quiz.qutn,
        selectedAnswer,
        arrayOf(quiz.ans1, quiz.ans2, quiz.anse3)[quiz.crectAns]
    )

}