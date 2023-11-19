package com.example.homework10_leacture13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework10_leacture13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var myAdaper: RecyclerComponentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUp()
    }

    private fun setUp(){
        myAdaper = RecyclerComponentAdapter()
        bindings()
    }

    private fun bindings(){
        binding.apply {
            recyclerViewId.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(this@MainActivity, 1)
                adapter = myAdaper
                submitList()
            }
        }

    }

    private fun submitList(){
        val componentsList = mutableListOf<Component>(
            Component(1,1,Icon.PROFILE),
            Component(1,2,Icon.LOCATION),
            Component(1,3,Icon.BELL),
            Component(1,4,Icon.WALLET),
            Component(1,5,Icon.SECURITY),
            Component(2,6,Icon.LANGUAGE),
            Component(3,7,Icon.MODE),
            Component(1,8,Icon.LOCK),
            Component(1,9,Icon.HELP),
            Component(1,10,Icon.FRIENDS),
            Component(1,11,Icon.LOGOUT)
        )

        myAdaper.submitList(componentsList)
    }
}