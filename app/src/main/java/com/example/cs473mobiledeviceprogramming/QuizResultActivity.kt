package com.example.cs473mobiledeviceprogramming

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cs473mobiledeviceprogramming.Model.ResultQuizModel
import kotlinx.android.synthetic.main.activity_quiz_result.*

class QuizResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)
        setupUI()
    }

    override fun onSupportNavigateUp(): Boolean {
        setResult(Activity.RESULT_OK)
        finish()
        return super.onSupportNavigateUp()
    }

    private fun setupUI() {
//        Utils.setStatusBarColor(this, R.color.colorBackground)
//        Utils.setActionBarColor(supportActionBar, resources, R.color.colorBackground)
        val result = intent.getParcelableArrayListExtra<ResultQuizModel>("result")
        if (result != null) {
            val totalQuestions = result.size
            var correctAnswers = 0
            result.forEach {
                if (it.SelectAns == it.corectAns) {
                    correctAnswers++
                }
            }
            total_questions_text_view.text = "Total questions: $totalQuestions"
            correct_answers_text_view.text = "Correct answers: $correctAnswers"
            wrong_answers_text_view.text = "Wrong answers: ${totalQuestions - correctAnswers}"
            score_text_view.text = "Your score is: $correctAnswers / $totalQuestions"
        }
    }

    fun tryAgainButtonClicked(view: View) {
        setResult(Activity.RESULT_OK)
        finish()
    }

    fun resultAnalysisButtonClicked(view: View) {
        val answers = intent.getParcelableArrayListExtra<ResultQuizModel>("result")
        val intent = Intent(this, QuizResultAnalysisActivity::class.java)
        if (answers != null) {
            intent.putParcelableArrayListExtra("result", answers)
        }
        startActivity(intent)
    }
}
