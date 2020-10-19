package com.bignerdranch.android.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // R is a reference to the resource. It is an auto-generated class with definitions for all
        // the resources in your app.
        setContentView(R.layout.activity_main)
    }
}
