package com.example.cs473mobiledeviceprogramming

import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.RadioButton
import com.example.cs473mobiledeviceprogramming.Model.QuizModel
import com.example.cs473mobiledeviceprogramming.Model.ResultQuizModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_qiuze.*
import java.io.IOException
import java.io.InputStream
import java.util.*

class QiuzeActivity : AppCompatActivity() {
       val counting_in_millis=30000
       var countDownTimer : CountDownTimer?=null
       var timeleftInMills:Long = 0

    var currentQuizIndex = 0
    var quizzes = arrayOf<QuizModel>()
    var answers = Array<ResultQuizModel?>(0) { null }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qiuze)
        setupUI()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SHOW_RESULT_ACTIVITY_RESULT_CODE && resultCode == Activity.RESULT_OK) {
            reset()
        }
    }

    private fun reset() {
        currentQuizIndex = 0
        answers = Array(quizzes.size) { null }
        showQuiz(0)
    }
    private fun setupUI() {
//        Utils.setStatusBarColor(this, R.color.quiz_foreground_color_dark)
//        Utils.setActionBarColor(supportActionBar, resources, R.color.quiz_foreground_color)

        val json = inputStreamToString(resources.openRawResource(R.raw.quiz))
        quizzes = Gson().fromJson(json, Array<QuizModel>::class.java)
        answers = Array(quizzes.size) { null }
        println("Json: $json")
        showQuiz(0)
    }

    fun inputStreamToString(inputStream: InputStream): String? {
        return try {
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)
            String(bytes)
        } catch (e: IOException) {
            null
        }
    }

    private fun showQuiz(index: Int) {
        val quiz = quizzes[index]
        answer_radio_group.clearCheck()
        question_text_view.text = quiz.qutn
        answer_1_radio_button.text = quiz.ans1
        answer_2_radio_button.text = quiz.ans2
        answer_3_radio_button.text = quiz.anse3
       answer_1_radio_button.isChecked = true
        timeleftInMills= counting_in_millis.toLong()
//        startCountDown()
    }
// fun   startCountDown() {
//
//     countDownTimer = object : CountDownTimer(20000, 1000) {
//         override fun onTick(millisUntilFinished: Long) {
//             timeleftInMills = millisUntilFinished
//             updateCountDownText()
//
//         }
//
//         fun  updateCountDownText(){
//             var minuts =(timeleftInMills/1000)/60 as Int
//             var seconds=(timeleftInMills/1000)%60 as Int
//             var timeformatted:String= String.format(Locale.getDefault(),"%02d:%02d",minuts,seconds)
//             textViewCountDown.setText(timeformatted)
//         }
//
//         override fun onFinish() {
//
//         }
//
//
//     }.start()
//
//
//
//
//
// }
    fun nextButtonClicked(view: View) {
        if (currentQuizIndex < quizzes.size - 1) {
            val selectedAnswer =
                findViewById<RadioButton>(answer_radio_group.checkedRadioButtonId).text.toString()
            val result = ResultQuizModel(quizzes[currentQuizIndex], selectedAnswer)
            answers[currentQuizIndex] = result
            currentQuizIndex++
            showQuiz(currentQuizIndex)
        } else {
            val selectedAnswer =
                findViewById<RadioButton>(answer_radio_group.checkedRadioButtonId).text.toString()
            val result = ResultQuizModel(quizzes[currentQuizIndex], selectedAnswer)
            answers[currentQuizIndex] = result
            val intent = Intent(this, QuizResultActivity::class.java)
            val arrayList = arrayListOf<ResultQuizModel>()
            arrayList.addAll(answers.filterNotNull())
            intent.putParcelableArrayListExtra("result", arrayList)
            startActivityForResult(intent, SHOW_RESULT_ACTIVITY_RESULT_CODE)
        }
    }

    fun homeButtonClicked(view: View) {
        if (currentQuizIndex < quizzes.size - 1) {
            currentQuizIndex++
            showQuiz(currentQuizIndex)
        } else {
            val intent = Intent(this, QuizResultActivity::class.java)
            val arrayList = arrayListOf<ResultQuizModel>()
            arrayList.addAll(answers.filterNotNull())
            intent.putParcelableArrayListExtra("result", arrayList)
            startActivityForResult(intent, SHOW_RESULT_ACTIVITY_RESULT_CODE)
        }
    }

    companion object {
        const val SHOW_RESULT_ACTIVITY_RESULT_CODE = 1
    }


}