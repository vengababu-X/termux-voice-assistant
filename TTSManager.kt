package com.example.voiceassistant

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.*

object TTSManager {

    private var tts: TextToSpeech? = null

    fun speak(text: String, context: Context) {
        if (tts == null) {
            tts = TextToSpeech(context) {
                tts?.language = Locale.US
                tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        } else {
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }
}
