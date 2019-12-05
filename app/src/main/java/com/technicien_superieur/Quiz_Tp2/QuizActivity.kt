package com.technicien_superieur.Quiz_Tp2

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import com.technicien_superieur.thequizcapitale.R
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

   //creation and implementation of variables: quiz list, index of correct answer, index of current quiz
    var quizs = ArrayList<Quiz>()
    var numberOfGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0


    // start the quiz activity page : activity_quiz
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // filling in the quiz list
        quizs.add(Quiz("Qui est le premier joueur africain à avoir remporté le ballon d'or ?", "Samuel Eto'o", "George Wea", "Didier Drogba", 2))
        quizs.add(Quiz("En quelle année a été aboli l'esclavage ?", "1848", "1810", "1900", 1))
        quizs.add(Quiz("Quel est le pys qui  organisé les jeux olympiques 2012 ?", "Allemagne", "France", "Grande Bretagne", 3))
        quizs.add(Quiz("Quei est le champion olympique en judo ?", "Hun Sung", "Tedi Riner", "Jofrey", 2))
        quizs.add(Quiz("Qui est l'uteur du livre les contemplations ?", "Victor Hugo", "Albert Camus", "Aimée Cesaire", 1))
        quizs.add(Quiz("En quelle année a eu lieu la seconde guerre mondiale ?", "1930", "1910", "1939", 3))
        quizs.add(Quiz("Quelle est la lettre la plus utilisée en programmation ?", "x", "i", "z", 2))



        showQuestion(quizs.get(currentQuizIndex))
    }

    // Function that displays a quiz
    fun showQuestion(quiz: Quiz) {
        txtQuestion.setText(quiz.question)
        answer1.setText(quiz.answer1)
        answer2.setText(quiz.answer2)
        answer3.setText(quiz.answer3)
    }

    // Function that checks the answer and note correct if true and incorrect otherwise
    fun handleAnswer(answerID: Int) {
        val quiz = quizs.get(currentQuizIndex)

        if (quiz.isCorrect(answerID)) {
            numberOfGoodAnswers++
            Toast.makeText(this, "Correcte", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrecte", Toast.LENGTH_SHORT).show()
        }

        // To go to the next question
        currentQuizIndex++

        // Check if the list is complete if yes announcement party ended and display the score
        if (currentQuizIndex >= quizs.size) { // Game over

            var alert = AlertDialog.Builder(this)
            alert.setTitle("Partie terminé!")
            alert.setMessage("Tu as eu : " + numberOfGoodAnswers + " bonne(s) réponse(s)")
            alert.setPositiveButton("OK") { dialogInterface: DialogInterface?, i: Int ->
                finish()
            }
            alert.show()

        } else { // We continue the game
            showQuestion(quizs.get(currentQuizIndex))
        }

    }

    // Retrieve the index of the selected answer
    fun onClickAnwerOne(view: View) {
        handleAnswer(1)
    }

    fun onClickAnwerTwo(view: View) {
        handleAnswer(2)
    }

    fun onClickAnwerThree(view: View) {
        handleAnswer(3)
    }


}
