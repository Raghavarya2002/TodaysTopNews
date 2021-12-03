package com.example.todaystopnews

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todaystopnews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NewsItemclicked {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        val items = fetchdata()
        val adapter: NewsListAdapter = NewsListAdapter(items,this)
        binding.recyclerview.adapter=adapter



    }

    private fun fetchdata():ArrayList<String>   {
        val list = ArrayList<String>()
        for(i in 0 until 100){
        list.add("Item $i")
        }
        return list
    }

    override fun onItemClicked(items: String) {
        Toast.makeText(this,"clicked item is $items" , Toast.LENGTH_SHORT).show()
    }


}