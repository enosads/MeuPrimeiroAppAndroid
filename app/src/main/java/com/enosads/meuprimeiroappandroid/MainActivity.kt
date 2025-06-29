package com.enosads.meuprimeiroappandroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.enosads.meuprimeiroappandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate")

        enableEdgeToEdge()

        val myClass = MyClass(context = applicationContext)

        showToast(context = this)

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
//        val url = "https://www.rocketseat.com.br"
//        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
//        startActivity(intent)
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

        binding.button.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

        supportFragmentManager.beginTransaction().add(
            R.id.flMainContainer, BlankFragment.newInstance(
                name = "Enos",
                age = 26,
                isMale = true
            )
        ).commit()
    }
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }

    fun showToast(context: Context) {
        Toast.makeText(context, "Hello World", Toast.LENGTH_SHORT).show()
    }
}
