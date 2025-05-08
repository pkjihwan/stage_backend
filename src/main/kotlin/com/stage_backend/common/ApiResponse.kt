package com.stage_backend.common

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.stage_backend.common.ApiResponse.ErrorMessage
import com.stage_backend.common.ApiResponse.ResultType.FAIL
import com.stage_backend.common.ApiResponse.ResultType.SUCCESS


class ApiResponse<T> @JsonCreator private constructor(
    val resultType: ResultType,
    @JsonProperty("success")
    val result: T?,
    val error: ErrorMessage?
) {
    companion object {
        fun <T> success(result: T): ApiResponse<T> =
            ApiResponse(SUCCESS, result, null)

        fun <T : Any> empty(): ApiResponse<T?> =
            ApiResponse(SUCCESS, null, null)

        fun <T> error(error: ErrorMessage, resultType: ResultType = FAIL): ApiResponse<T> =
            ApiResponse(resultType, null, error)

        fun error(
            reason: String,
            errorCode: String,
            data: Map<String, Any>? = null,
            title: String? = null
        ): ApiResponse<Unit> =
            ApiResponse(FAIL, null, ErrorMessage(reason, errorCode, data, title))
    }

    enum class ResultType {
        SUCCESS,
        FAIL;

        fun success(): Boolean = this == SUCCESS

        fun fail(): Boolean = !success()
    }

    class ErrorMessage(
        val reason: String,
        val errorCode: String,
        val data: Map<String, Any>? = null,
        val title: String? = null
    ) {
        companion object {
            val EMPTY = ErrorMessage("Empty error message", "")
        }
    }
}

fun <T> T.toResponse(): ApiResponse<T> = ApiResponse.success(this)
fun <T> ErrorMessage.toResponse(): ApiResponse<T> = ApiResponse.error(this)
fun <T> Throwable.toResponse(): ApiResponse<T> = ErrorMessage(this.localizedMessage, "500").toResponse()
