package com.example.cs473mobiledeviceprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cs473mobiledeviceprogramming.Adapter.QuizResultAdapter
import com.example.cs473mobiledeviceprogramming.Model.ResultQuizModel
import kotlinx.android.synthetic.main.activity_quiz_result_analysis.*

class QuizResultAnalysisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result_analysis)
        setupUI()
    }

    private fun setupUI() {
//        Utils.setStatusBarColor(this, R.color.colorBackground)
//        Utils.setActionBarColor(supportActionBar, resources, R.color.colorBackground)
        val result = intent.getParcelableArrayListExtra("result") ?: ArrayList<ResultQuizModel>()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = QuizResultAdapter(result)
    }
}
