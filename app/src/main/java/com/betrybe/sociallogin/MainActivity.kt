package com.betrybe.sociallogin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.betrybe.sociallogin.R.id.login_button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private val emailInput:TextInputEditText by lazy { findViewById(R.id.email_input) }
    private val passwordInput:TextInputEditText by lazy { findViewById(R.id.password_input) }
    private val loginButton:Button by lazy { findViewById(login_button) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailInput.addTextChangedListener { enableButton() }
        passwordInput.addTextChangedListener { enableButton() }
    }

    private fun enableButton() {
        val email = emailInput.text.toString().trim()
        val password = passwordInput.text.toString().trim()

        loginButton.isEnabled = email.isNotEmpty() && password.isNotEmpty()
    }
}
