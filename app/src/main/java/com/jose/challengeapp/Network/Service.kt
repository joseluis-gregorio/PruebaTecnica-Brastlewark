package com.jose.challengeapp.Network

import com.jose.challengeapp.ResponseInformationDTO
import retrofit2.*
import retrofit2.http.*

interface Service {
    @GET("/rrafols/mobile_test/master/data.json")
    fun getInformation(): Call<ResponseInformationDTO>
}