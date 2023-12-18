package com.example.moviegames

import androidx.appcompat.app.AppCompatActivityimport android.os.Bundle
import androidx.databinding.DataBindingUtilimport com.example.game.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }
}