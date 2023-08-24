package com.ahmet.bostanciklioglu.makeupappkotlin.data.api

import com.ahmet.bostanciklioglu.makeupappkotlin.data.model.ProductsList
import com.ahmet.bostanciklioglu.makeupappkotlin.util.Resource
import retrofit2.Response
import timber.log.Timber

abstract class ApiResponse {

    //This checks whether the response is successful or not and sends the result
    suspend fun safeApiCall(
        apiCall: suspend () -> Response<ProductsList>
    ): Resource<ProductsList> {
        try {
            Timber.tag("ApiResponse").d("checking...")
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Resource.Success(body)
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun error(errorMessage: String): Resource<ProductsList> =
        Resource.Error("Api call failed $errorMessage")
}

