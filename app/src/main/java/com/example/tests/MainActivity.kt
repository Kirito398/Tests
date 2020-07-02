package com.example.tests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tests.utils.PasswordUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        btnCheckPassword.setOnClickListener {
            if (PasswordUtil.isStrongPassword(etPassword.text.toString()))
                tvPasswordStatus.text = "Сильный"
            else
                tvPasswordStatus.text = "Слабый"
        }
    }
}