package com.technicien_superieur.Quiz_Tp2

// creation of the quiz class and its constructor
class Quiz(var question: String, var answer1: String, var answer2: String, var answer3: String, var correctAnswerNumber: Int) {

    // Creation of the verifying function if the given answer is correct and returns a boolean from the index received in parameter
    fun isCorrect(answerNumber: Int) : Boolean {
        if (answerNumber == correctAnswerNumber)
            return true

        return false
    }

}