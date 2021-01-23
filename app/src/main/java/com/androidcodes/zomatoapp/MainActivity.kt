package com.androidcodes.zomatoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androidcodes.zomatoapp.model.Restaurant
import com.androidcodes.zomatoapp.repo.Repository
import com.androidcodes.zomatoapp.views.AppViewModel
import com.androidcodes.zomatoapp.views.AppViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchQuery = "Nightlife"

        val repository = Repository()
        val viewModelFactory = AppViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AppViewModel::class.java)

        viewModel.getSearchResponse(searchQuery)
        viewModel.newApiResponse.observe(this, Observer {
            response ->
            if (response.isSuccessful){
                Log.d("RESPONSE", "Getting the response code: ${response.code()}")
                Log.d("RESPONSE", "==============================================")
                Log.d("RESPONSE", "Getting the response body: ${response.body()}")
                Log.d("RESPONSE", "==============================================")
                Log.d("RESPONSE", "Getting the response name: ${response.body()!!.restaurants.get(1).restaurant.name}")

                val sizeOfRest = response.body()!!.restaurants.size
                Log.d("RESPONSE", "Restaurant Size: $sizeOfRest")

                for (element in response.body()!!.restaurants){
                    Log.d("RESPONSE", "Restaurant Name: ${element.restaurant.name}")
//                    Log.d("RESPONSE", "==============================================")
                    Log.d("RESPONSE", "Average Price For Two: ${element.restaurant.average_cost_for_two}")
                    Log.d("RESPONSE", "Cuisines: ${element.restaurant.cuisines}")
                }
            }else{
                Log.d("RESPONSE", "Getting the response error: ${response.errorBody()}")
            }
        })

    }
}