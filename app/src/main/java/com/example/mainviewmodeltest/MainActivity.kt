package com.example.mainviewmodeltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mainviewmodeltest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: TestViewModel by lazy {
        ViewModelProvider(
            this,
            TestViewModelFactory(0)
        ).get(TestViewModel::class.java)
    }
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        viewModel.number.observe(this, Observer {
            binding.text1.text = it?.toString()
        })


        binding.btnAddOne.setOnClickListener { viewModel.add(1) }
        binding.btnAddTwo.setOnClickListener { viewModel.add(2) }
    }
}

