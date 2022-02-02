package com.example.inshortsclone.ui.base
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.inshortsclone.utils.CustomAlert
import com.example.inshortsclone.utils.CustomProgressDialog


open class BaseActivity : AppCompatActivity() {
    var progress: CustomProgressDialog? = null
    var alert: CustomAlert? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progress = CustomProgressDialog(this)
        alert = CustomAlert(this)
    }

}