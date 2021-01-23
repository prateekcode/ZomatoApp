package com.androidcodes.zomatoapp.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidcodes.zomatoapp.model.Restaurant
import com.androidcodes.zomatoapp.model.SearchModel
import com.androidcodes.zomatoapp.repo.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class AppViewModel(private val repository: Repository): ViewModel() {

    val apiResponse: MutableLiveData<Response<List<SearchModel>>> = MutableLiveData()



    val anotherApiResponse: MutableLiveData<SearchModel> = MutableLiveData()

//    fun getRestaurant(restaurant: Restaurant){
//        viewModelScope.launch {
//            val response = repository.getRestroResponse(restaurant)
//            apiResponse.value = response
//        }
//    }


    val newApiResponse: MutableLiveData<Response<SearchModel>> = MutableLiveData()
    fun getSearchResponse(query: String){
        viewModelScope.launch {
            val newResponse = repository.getSearchResponse(query)
            newApiResponse.value = newResponse
        }
    }

    //Search without Retrofit Response
//    fun getSearched(query: String){
//        viewModelScope.launch {
//            val anotherNewResponse = repository.getSearch("Whiskey")
//            anotherApiResponse.value = anotherNewResponse
//        }
//    }

//    fun sumTwoNumber(a: Int, b:Int): Int {
//        return a+b
//    }

}