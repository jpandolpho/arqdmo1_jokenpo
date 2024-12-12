package br.edu.ifsp.dmo1.jokenpo.model

import kotlin.random.Random

class Player(var name: String) {
    var points: Int = 0
        private set

    init {
        if (name.isEmpty())
            name = "BOT${Random.nextInt(20)}"
    }

    fun recordPoint() {
        points += 1
    }
}