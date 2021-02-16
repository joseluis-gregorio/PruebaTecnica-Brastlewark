package com.jose.challengeapp.Network

import com.jose.challengeapp.ErrorDTO
import com.jose.challengeapp.ResponseInformationDTO
import retrofit2.*
object ServiceManager: RequestManager(){
    fun getInformation(responseInformation: (responseDTO: ResponseInformationDTO?, error: ErrorDTO?) -> Unit){
        getClient().getInformation().enqueue(object :
            Callback<ResponseInformationDTO> {
            override fun onFailure(call: Call<ResponseInformationDTO>, t: Throwable) {
                val errorDTO = ErrorDTO(FailRequest,t.message ?: FailRequestMessage)
                responseInformation.invoke(null,errorDTO)
            }
            override fun onResponse(call: Call<ResponseInformationDTO>, response: Response<ResponseInformationDTO>) {
                responseInformation.invoke(response.body(),if (response.isSuccessful) null else ErrorDTO(FailRequest,FailRequestServerMessage))
            }
        })
    }
}