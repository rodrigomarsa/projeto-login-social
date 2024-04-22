package com.betrybe.sociallogin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.betrybe.sociallogin.R.id.login_button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val emailInput:TextInputEditText by lazy { findViewById(R.id.email_input) }
    private val emailLayout:TextInputLayout by lazy { findViewById(R.id.email_text_input_layout) }
    private val passwordInput:TextInputEditText by lazy { findViewById(R.id.password_input) }
    private val passwordLayout:TextInputLayout by lazy { findViewById(R.id.password_text_input_layout) }
    private val loginButton:Button by lazy { findViewById(login_button) }

    private val email: String
        get() = emailInput.text.toString().trim()

    private val password: String
        get() = passwordInput.text.toString().trim()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailInput.addTextChangedListener { enableButton() }
        passwordInput.addTextChangedListener { enableButton() }

        loginButton.setOnClickListener {
            validateFields(email, password)
            Snackbar.make(findViewById(android.R.id.content), R.string.login_succeeded, Snackbar.LENGTH_SHORT).show()
    }
}

    private fun enableButton() {
        loginButton.isEnabled = email.isNotEmpty() && password.isNotEmpty()
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
        return email.matches(emailPattern.toRegex())
    }

    private fun validateFields(email: String, password: String): Boolean {
        var hasError = false

        if (!isValidEmail(email)) {
            emailLayout.error = "Email inválido"
            hasError = true
        } else {
            emailLayout.error = null
        }

        if (password.length < 4) {
            passwordLayout.error = "Senha deve ter mais de 4 caracteres"
            hasError = true
        } else {
            passwordLayout.error = null
        }

        return hasError
    }
    }
