package com.jose.challengeapp

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.airbnb.lottie.LottieAnimationView

typealias DialogCallDissmis = (DialogFragment) -> Unit

class LoadingDialog : DialogFragment() {

    var onDismis: DialogCallDissmis? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.base_loader,container,false)
        val animation_view = view.findViewById<LottieAnimationView>(R.id.animation_view)
        dialog?.window?.setBackgroundDrawableResource(R.color.whiteLoader)
        animation_view.playAnimation()
        return view
    }

    override fun getTheme(): Int {
        return R.style.DialogFullScreen
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismis?.invoke(this)
    }
}