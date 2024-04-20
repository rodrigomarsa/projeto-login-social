package com.betrybe.sociallogin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.betrybe.sociallogin.R.id.login_button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val emailInput:TextInputEditText by lazy { findViewById(R.id.email_input) }
    private val emailLayout:TextInputLayout by lazy { findViewById(R.id.email_text_input_layout) }
    private val passwordInput:TextInputEditText by lazy { findViewById(R.id.password_input) }
    private val loginButton:Button by lazy { findViewById(login_button) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailInput.addTextChangedListener { enableButton() }
        passwordInput.addTextChangedListener { enableButton() }

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            if (isValidEmail(email)) {
                emailLayout.error = null
            } else {
                emailLayout.error = "Email inválido"
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9.]+@[a-zA-Z]+.[a-zA-Z]+"
        return email.matches(emailPattern.toRegex())
    }

    private fun enableButton() {
        val email = emailInput.text.toString().trim()
        val password = passwordInput.text.toString().trim()

        loginButton.isEnabled = email.isNotEmpty() && password.isNotEmpty()
    }
}
