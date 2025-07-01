package com.enosads.meuprimeiroappandroid

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.enosads.meuprimeiroappandroid.broadcastreceiver.LowBatteryBroadcastReceiver
import com.enosads.meuprimeiroappandroid.databinding.ActivityMainBinding
import com.enosads.meuprimeiroappandroid.service.SyncDataService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val lowBatteryBroadcastReceiver = LowBatteryBroadcastReceiver()
    private val lowBatteryIntentFilter = IntentFilter("android.intent.action.BATTERY_LOW")
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate")

        enableEdgeToEdge()

        val myClass = MyClass(context = applicationContext)

        showToast(context = this)

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
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
            showGoToMainActivity2Notification()

//            val url = "https://www.rocketseat.com.br"
//            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
//            startActivity(intent)
//            startActivity(Intent(this, MainActivity2::class.java))
        }

        supportFragmentManager.beginTransaction().add(
            R.id.flMainContainer, BlankFragment.newInstance(
                name = "Enos",
                age = 26,
                isMale = true
            )
        ).commit()
        registerReceiver(lowBatteryBroadcastReceiver, lowBatteryIntentFilter)
        val intent = Intent(this, SyncDataService::class.java)
        startService(intent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    private fun showGoToMainActivity2Notification() {
        val intentGoToMainActivity2 = Intent(this, MainActivity2::class.java)
        val pendingIntentGoToMainActivity2 = PendingIntent.getActivity(
            this,
            0,
            intentGoToMainActivity2,
            PendingIntent.FLAG_IMMUTABLE
        )
        // Cria notificação
        val notification = NotificationCompat.Builder(this, "channel_id")
            .setContentTitle("Notificação")
            .setContentText("Toque para abrir a MainActivity2")
            .setSmallIcon(android.R.drawable.ic_notification_overlay)
            .setContentIntent(pendingIntentGoToMainActivity2)
            .setAutoCancel(true)
            .build()

        // Exibe notificação
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
            && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
        ) {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            return
        }
        val manager = getSystemService(NotificationManager::class.java)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "channel_id",
                "Channel Name",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            manager.createNotificationChannel(channel)
        }
        manager.notify(1, notification)
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
        unregisterReceiver(lowBatteryBroadcastReceiver)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }

    fun showToast(context: Context) {
        Toast.makeText(context, "Hello World", Toast.LENGTH_SHORT).show()
    }
}
