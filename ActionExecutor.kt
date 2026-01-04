package com.example.voiceassistant

import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

object ActionExecutor {

    fun execute(action: String, context: Context) {
        when (action) {
            "OPEN_CAMERA" -> {
                val intent = Intent("android.media.action.IMAGE_CAPTURE")
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(intent)
            }
            else -> {
                Toast.makeText(context, "Action: $action", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
