package com.surivalcoding.intentexam

import android.content.Intent
import android.net.Uri
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

        val editText = findViewById<EditText>(R.id.edit_text_1)

        // 값 넘기기
        findViewById<Button>(R.id.button2).setOnClickListener {
            // TargetActivity 한테 뭔가 해야지
            val intent = Intent(this, TargetActivity::class.java)

            // 넘길 값 설정
            intent.putExtra("value", editText.text.toString())

            // 새로운 액티비티 시작
            startActivity(intent)
        }

        // 전화 걸기
        findViewById<Button>(R.id.call_button).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + editText.text.toString())

//            if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
//            }
        }

        // 문자앱 불러서 연동
        findViewById<Button>(R.id.share_text_button).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:01011112222")
                putExtra("sms_body", editText.text.toString())
            }

            startActivity(intent)
        }

        // 웹 브라우저 실행
        findViewById<Button>(R.id.open_web_button).setOnClickListener {
            openWebPage("https://www.naver.com")
        }

    }

    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }
}