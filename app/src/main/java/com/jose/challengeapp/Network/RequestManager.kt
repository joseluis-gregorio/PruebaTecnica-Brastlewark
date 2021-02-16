package com.jose.challengeapp.Network

import com.jose.challengeapp.BuildConfig
import com.jose.challengeapp.Constants


open class RequestManager: Constants {

    fun getClient() : Service {
        val client = Client()
            .getClient(BuildConfig.URL_BASE)
            .create(Service::class.java)
        return client
    }
}