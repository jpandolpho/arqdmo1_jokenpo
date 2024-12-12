package br.edu.ifsp.dmo1.jokenpo.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.jokenpo.databinding.ActivitySelectionBinding
import br.edu.ifsp.dmo1.jokenpo.model.Paper
import br.edu.ifsp.dmo1.jokenpo.model.Rock
import br.edu.ifsp.dmo1.jokenpo.model.Scissors
import br.edu.ifsp.dmo1.jokenpo.model.Weapon

class SelectionActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivitySelectionBinding
    private var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name: String? = ""
        val extras = intent.extras
        if (extras != null) {
            name = extras.getString(Constants.KEY_PLAYER_NUMBER)
            number = extras.getInt(Constants.KEY_PLAYER_NUMBER)
        }

        actionBar?.hide()

        binding.buttonPaper.setOnClickListener(this)
        binding.buttonRock.setOnClickListener(this)
        binding.buttonScissors.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val weapon = when {
            v == binding.buttonPaper -> Paper
            v == binding.buttonRock -> Rock
            v == binding.buttonScissors -> Scissors
            else -> null
        }
        handleResult(weapon)
    }

    private fun handleResult(weapon: Weapon?) {
        if (weapon == null) {
            setResult(RESULT_CANCELED)
        } else {
            val mIntent = Intent()
            mIntent.putExtra(Constants.KEY_PLAYER_NUMBER, number)
            mIntent.putExtra(Constants.KEY_WEAPON, weapon)
            setResult(RESULT_OK, mIntent)
        }
        finish()
    }
}