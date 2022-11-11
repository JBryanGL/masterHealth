package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.databinding.ActivityApiBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api : AppCompatActivity(),android.widget.SearchView.OnQueryTextListener {

    private lateinit var binding:ActivityApiBinding
    private lateinit var adapter: adapter
    private val apiImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityApiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.svApi.setOnQueryTextListener(this)
        initRecycleView()
    }

    private fun initRecycleView() {
        binding.rvApi.layoutManager=LinearLayoutManager(this)
        adapter= adapter(apiImages)
        binding.rvApi.adapter=adapter
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(apiService::class.java).getInformation("$query/images")
            val call2 = call.body()
            runOnUiThread{
                if(call.isSuccessful){
                    //show recyclerview
                    val images = call2?.images ?: emptyList()
                    apiImages.clear()
                    apiImages.addAll(images)
                    adapter.notifyDataSetChanged()
                }else{
                    //show error
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this,"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}