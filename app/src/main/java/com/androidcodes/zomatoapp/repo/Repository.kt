package com.androidcodes.zomatoapp.repo

import com.androidcodes.zomatoapp.api.RetrofitInstance
import com.androidcodes.zomatoapp.model.Restaurant
import com.androidcodes.zomatoapp.model.SearchModel
import retrofit2.Response

class Repository {

//    suspend fun getRestroResponse(restaurant: Restaurant):Response<List<SearchModel>>{
//        return RetrofitInstance.api.getRestro(restaurant)
//    }

    suspend fun getSearchResponse(query: String): Response<SearchModel>{
        return RetrofitInstance.api.getSearchResponse(query)
    }

//    suspend fun getSearch(query: String): SearchModel{
//        return RetrofitInstance.api.getSearch(query)
//    }

}

//MVVM - Model View ViewModel