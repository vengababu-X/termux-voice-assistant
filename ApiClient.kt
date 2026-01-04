package com.example.voiceassistant

import android.content.Context
import android.os.StrictMode
import android.widget.Toast
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

object ApiClient {

    private const val URL = "http://127.0.0.1:5000/process"

    fun sendText(text: String, context: Context) {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        )

        val json = JSONObject()
        json.put("text", text)

        val body = json.toString()
            .toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url(URL)
            .post(body)
            .build()

        val client = OkHttpClient()
        val response = client.newCall(request).execute()
        val responseBody = response.body?.string() ?: return

        ResponseHandler.handle(responseBody, context)
    }
}
