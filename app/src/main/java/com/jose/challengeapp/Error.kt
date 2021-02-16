package com.jose.challengeapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ErrorDTO (
    @SerializedName("type")
    var type:String,
    @SerializedName("message")
    var message:String): Serializable
