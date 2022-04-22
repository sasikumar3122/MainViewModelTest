package com.example.mainviewmodeltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mainviewmodeltest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: TestViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val View = binding.root
        setContentView(View)



        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        viewModel.currentNumber.observe(this , Observer {
            binding.text1.text = it.toString()
        })

        incrementText()

    }

    private fun incrementText() {
        binding.btnAddOne.setOnClickListener{

            viewModel.currentNumber.value = ++viewModel.number
        }
        binding.btnAddTwo.setOnClickListener{

            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentNumber.value = ++viewModel.number
        }

    }
}