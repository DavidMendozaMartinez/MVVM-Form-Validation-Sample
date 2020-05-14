package com.davidmendozamartinez.mvvm.form.validation.sample

enum class Validation(private val errorId: Int, private val validation: (String) -> Boolean) {
    NOT_EMPTY_FIELD(R.string.error_empty_field, { field ->
        field.isNotEmpty()
    }),
    VALID_EMAIL(R.string.error_invalid_email, { email ->
        android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }),
    VALID_PASSWORD(R.string.error_invalid_password, { password ->
        password.length >= 8
    });

    fun isValid(field: String): Boolean = validation.invoke(field)
    fun getErrorId(): Int = errorId
}