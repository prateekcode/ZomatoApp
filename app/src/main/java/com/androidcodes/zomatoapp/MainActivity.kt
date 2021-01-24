package com.androidcodes.zomatoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidcodes.zomatoapp.adapter.ResponseAdapter
import com.androidcodes.zomatoapp.model.Response
import com.androidcodes.zomatoapp.model.Restaurant
import com.androidcodes.zomatoapp.repo.Repository
import com.androidcodes.zomatoapp.views.AppViewModel
import com.androidcodes.zomatoapp.views.AppViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AppViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: ResponseAdapter
    private val responseList = ArrayList<Response>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchQuery = "Delhi"

        recyclerView = item_list
        recyclerAdapter = ResponseAdapter(responseList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerAdapter

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

                    val item = Response(element.restaurant.name, element.restaurant.average_cost_for_two.toString(), element.restaurant.cuisines)
                    responseList.add(item)
                }
            }else{
                Log.d("RESPONSE", "==============================================")
                Log.d("RESPONSE", "Getting the response error: ${response.message()}")
                Log.d("RESPONSE", "==============================================")
                Log.d("RESPONSE", "Getting the response error: ${response.errorBody()}")
            }
        })

    }
}