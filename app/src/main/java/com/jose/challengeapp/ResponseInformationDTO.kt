package com.jose.challengeapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseInformationDTO (

    @SerializedName("Brastlewark") val brastlewark : List<Brastlewark>
)

class Brastlewark: Serializable {
    @SerializedName("id")
    val id:Int? = null

    @SerializedName("name")
    val name:String? = null

    @SerializedName("thumbnail")
    val thumbnail:String? = null

    @SerializedName("age")
    val age:Int? = null

    @SerializedName("weight")
    val weight:Double? = null

    @SerializedName("height")
    val height:Double? = null

    @SerializedName("hair_color")
    val hair_color : String?=null

    @SerializedName("professions")
    val professions : List<String>?=null

    @SerializedName("friends")
    val friends : List<String>?=null

    fun getImageURL():String=thumbnail?.replace("http","https") ?:""
}
