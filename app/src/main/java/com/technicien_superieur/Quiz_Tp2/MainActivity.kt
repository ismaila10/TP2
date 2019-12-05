package com.technicien_superieur.Quiz_Tp2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.technicien_superieur.thequizcapitale.R

class MainActivity : AppCompatActivity() {

    // start the main page : activity_main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Action of the play button: load the quizActivity page
    fun onClickBtnPlay(view:View) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }


}
