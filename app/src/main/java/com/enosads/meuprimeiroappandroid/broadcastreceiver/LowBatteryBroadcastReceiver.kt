package com.enosads.meuprimeiroappandroid.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class LowBatteryBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BATTERY_LOW) {
            Toast.makeText(context, "Evento de bateria baixa recebido!", Toast.LENGTH_SHORT).show()
        }
    }
}
