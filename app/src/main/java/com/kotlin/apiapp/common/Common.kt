package com.kotlin.apiapp.common

import android.content.Context
import android.widget.Toast

object Common {

    fun showMessage(context: Context, message:String)
    {
        Toast.makeText(context,"$message", Toast.LENGTH_SHORT).show()
    }
}