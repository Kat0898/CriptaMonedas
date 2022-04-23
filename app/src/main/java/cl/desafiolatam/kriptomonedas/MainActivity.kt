package cl.desafiolatam.kriptomonedas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cl.desafiolatam.kriptomonedas.databinding.ActivityMainBinding
import cl.desafiolatam.kriptomonedas.viewModel.ViewCripto

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<ViewCripto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getData()

    }
}