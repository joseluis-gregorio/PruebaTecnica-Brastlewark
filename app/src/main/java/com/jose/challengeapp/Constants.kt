package com.jose.challengeapp


interface Constants {
    val FailRequest: String get() = "FaillRequest"
    val BadCredentials: String get() = "BadCredentials"
    val FailRequestMessage: String get() = "No se pudo realizar la solicitud algo salió mal"
    val FailRequestServerMessage: String get() = "No se puede conectar al servidor"
    val FailRequestServerConnectioMessage: String get() = "Server Error Conection"
    val CastError: String get() = "Error de Casteo"
    val unknown: String get()="Unknown"
    val CastErrorMessage: String get() = "No fue posible trasformar el objeto"
    val DataNull: String get() = "Data Null"
    val success: String get() = "Success"
    val EMPTY: String get() = ""
    val INHABITANT: String get() = "INHABITANT"
}
