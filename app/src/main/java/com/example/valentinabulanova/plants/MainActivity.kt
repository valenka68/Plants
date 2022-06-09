package com.example.valentinabulanova.plants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valentinabulanova.plants.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.delfinium,
        R.drawable.gortenziya,
        R.drawable.romashka,
        R.drawable.roza,
        R.drawable.vasilek
    )
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3 )
            rcView.adapter = adapter
            bAdd.setOnClickListener {
                if (index > 4) index = 0
                val plant = Plant (imageIdList[index], "Plant $index")
                adapter.addPlant(plant)
                index++
            }
        }
    }


}