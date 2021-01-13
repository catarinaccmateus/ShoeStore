package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
    }
}
