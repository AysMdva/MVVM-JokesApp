package com.aysmdva.mvvm_jokesapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aysmdva.mvvm_jokesapp.R
import com.aysmdva.mvvm_jokesapp.databinding.ActivityMainBinding
import com.aysmdva.mvvm_jokesapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var progressBar: ProgressBar
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressBar = binding.progressBar
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.button.setOnClickListener {
            viewModel.fetchJoke(this)
            progressBar.visibility = View.VISIBLE
        }

        viewModel.observeData().observe(this, { data ->

            binding.tvJokes.text = data.joke
            progressBar.visibility = View.GONE
        })
    }
}