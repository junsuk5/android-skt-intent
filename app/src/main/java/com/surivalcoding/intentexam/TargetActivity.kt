package com.surivalcoding.intentexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TargetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)

        val textView = findViewById<TextView>(R.id.textView)

        // 나를 실행한 Intent가 뭔가?
        // Intent에 뭐가 들어있나?
        val value = intent?.getStringExtra("value") ?: "No Data"

        textView.text = value
    }
}