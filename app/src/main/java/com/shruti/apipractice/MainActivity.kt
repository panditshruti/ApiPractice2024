package com.shruti.apipractice

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shruti.apipractice.adapter.UserAdapter
import com.shruti.apipractice.databinding.ActivityMainBinding
import com.shruti.apipractice.model.UserModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userModel: UserModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


           userModel = ViewModelProvider(this)[UserModel::class.java]
        userModel.getUserModel()

        userModel.userLiveData.observe(this){
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            userAdapter = UserAdapter(it)
            binding.recyclerView.adapter = userAdapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
        }

    }
}

