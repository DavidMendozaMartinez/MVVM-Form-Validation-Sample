package com.davidmendozamartinez.mvvm.form.validation.sample

import android.widget.EditText
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter

@BindingAdapter("app:error")
fun EditText.bindError(@StringRes errorId: Int?) {
    error = errorId?.let { context.getString(it) }
}