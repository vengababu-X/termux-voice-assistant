package com.example.voiceassistant

import android.content.Context
import org.json.JSONObject

object ResponseHandler {

    fun handle(response: String, context: Context) {
        val json = JSONObject(response)
        val type = json.getString("type")

        if (type == "action") {
            val action = json.getString("action")
            ActionExecutor.execute(action, context)
        } else if (type == "reply") {
            val text = json.getString("text")
            TTSManager.speak(text, context)
        }
    }
}
