package com.ecourier.courier.data.datasource.exceptions
/**
 * Created by Pratiksha on 26/3/21.
 */

class ExceptionFactory {

    companion object {

        fun create(code: Int, message: String?): Exception {
            when (code) {
//                404 -> {
//                    return UserNotFoundException(message)
//                }
//                409 -> {
//                    return UserAlreadyExistException(message)
//                }
                401 -> {
                    return UnauthorizedException(message)
                }
//
//                500 -> {
//                    return ServerException(message)
//                }
//
                else -> return ServerException(message)
            }
        }
    }
}
