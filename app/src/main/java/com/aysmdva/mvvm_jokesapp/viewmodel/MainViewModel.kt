package com.aysmdva.mvvm_jokesapp.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysmdva.mvvm_jokesapp.model.Joke
import com.aysmdva.mvvm_jokesapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    var data = MutableLiveData<Joke>()

    fun fetchJoke(context: Context) {
        RetrofitService.service?.getAPI()?.fetchJoke()?.enqueue(object : Callback<Joke> {
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                val data = response.body() as Joke
                this@MainViewModel.data.postValue(data)
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Toast.makeText(context, "Error Occured", Toast.LENGTH_LONG).show()
            }

        })

    }

    fun observeData(): LiveData<Joke> {
        return data
    }
}