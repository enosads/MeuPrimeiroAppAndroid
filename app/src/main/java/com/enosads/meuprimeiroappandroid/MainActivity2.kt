package com.enosads.meuprimeiroappandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AppProcesses {
    fun startMusic(){
        Log.d("MainActivity2", "AppProcesses: Music Started")
    }
    fun stopMusic(){
        Log.d("MainActivity2", "AppProcesses: Music stoped")
    }
    fun deleteTemporaryCacheFiles(){
        Log.d("MainActivity2", "AppProcesses: Temporary files deleted")
    }
    fun createTemporaryCacheFiles(){
        Log.d("MainActivity2", "AppProcesses: Temporary files created")
    }
    fun startLongRunningTasks(){
        Log.d("MainActivity2", "AppProcesses: Long running tasks started")
    }
    fun stopLongRunningTasks(){
        Log.d("MainActivity2", "AppProcesses: Long running tasks stopped")
    }
    fun setupLayout(){
        Log.d("MainActivity2", "AppProcesses: Layout setup")
    }
}

class MainActivity2 : AppCompatActivity() {
    private val myProcesses by lazy { AppProcesses() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity2", "onCreate: MainActivity2")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myProcesses.setupLayout()
        myProcesses.createTemporaryCacheFiles()
    }
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity2", "onStart")
        myProcesses.startLongRunningTasks()
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity2", "onResume")
        myProcesses.startMusic()
    }

    override fun onPause() {
        super.onPause()
        //...
        Log.d("MainActivity2", "onPause")
        myProcesses.stopMusic()

    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity2", "onStop")
        myProcesses.stopLongRunningTasks()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity2", "onDestroy")
        myProcesses.deleteTemporaryCacheFiles()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity2", "onRestart")
//        myProcesses.restartLongRunningTasks()
    }

}