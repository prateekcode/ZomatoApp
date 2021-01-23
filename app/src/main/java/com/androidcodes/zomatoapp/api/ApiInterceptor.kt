package com.androidcodes.zomatoapp.api

import com.androidcodes.zomatoapp.utils.Constants.Companion.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("user-key", API_KEY)
            .build()
        return chain.proceed(request)
    }
}