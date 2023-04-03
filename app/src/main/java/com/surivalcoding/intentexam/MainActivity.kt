package com.surivalcoding.intentexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 이동
        findViewById<Button>(R.id.button1).setOnClickListener {
            // TargetActivity 한테 뭔가 해야지
            val intent = Intent(this, TargetActivity::class.java)
            // 새로운 액티비티 시작
            startActivity(intent)
        }

        // 값 넘기기
        findViewById<Button>(R.id.button2).setOnClickListener {
            // TargetActivity 한테 뭔가 해야지
            val intent = Intent(this, TargetActivity::class.java)

            // 넘길 값 설정
            val editText = findViewById<EditText>(R.id.edit_text_1)
            intent.putExtra("value", editText.text)

            // 새로운 액티비티 시작
            startActivity(intent)
        }

    }
}