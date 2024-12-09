package br.edu.ifsp.dmo1.jokenpo.model

class Player(val name: String) {
    var points: Int = 0
        private set

    fun recordPoint() {
        points += 1
    }
}