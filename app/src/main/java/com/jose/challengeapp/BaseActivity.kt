package com.jose.challengeapp

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity : AppCompatActivity(),Constants {
    var dialogLoading: LoadingDialog? = null

    fun initToolbar(title:String){
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.title = title
    }

    fun enableBack(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    fun showLoader(){
        dialogLoading = LoadingDialog()
        dialogLoading?.show(supportFragmentManager,"LoadingDialog")
    }

    fun dismisLoader(){
        if (dialogLoading != null) {
            dialogLoading?.dismissAllowingStateLoss()
        }
    }
}