package com.jose.challengeapp.Network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class BasicAuth()
class AuthGeneralInter: Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest = request.newBuilder()
            .addHeader("Accept", "*/*")
            .addHeader("User-Agent","MccClient/1.0")
            .build()
        return chain.proceed(authenticatedRequest)
    }
}