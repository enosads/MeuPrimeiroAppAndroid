package com.enosads.meuprimeiroappandroid

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.enosads.meuprimeiroappandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding.tvMyFirstAndroidApp) {
            text = "Meu primeiro App Android!"
            textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        }

        supportFragmentManager.beginTransaction().add(
            R.id.flMainContainer, BlankFragment.newInstance(
                name = "Enos",
                age = 26,
                isMale = true
            )
        ).commit()
    }
}
