package com.ecourier.courier.data.datasource.exceptions

class NetworkUnavailableException : Throwable() {

    override val message: String?
        get() = "Please check your network connectivity"
}