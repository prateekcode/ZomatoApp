package com.androidcodes.zomatoapp.api

import com.androidcodes.zomatoapp.model.Restaurant
import com.androidcodes.zomatoapp.model.SearchModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    //Wrong Function
//    @GET("api/v2.1/")
//    suspend fun getRestro(@Query("restaurants") restaurant: Restaurant) : Response<List<SearchModel>>

    // Function to search
    @GET("search?")
    suspend fun getSearchResponse(@Query("q") query:String) : Response<SearchModel>


//    // Function to search without retrofit response
//    @GET("search?")
//    suspend fun getSearch(@Query("q") query:String) : SearchModel

}

