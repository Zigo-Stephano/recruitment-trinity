 package com.example.recruitmenttrinity.ui.main

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recruitmenttrinity.data.model.ResponseUser
import com.example.recruitmenttrinity.databinding.ActivityMainBinding
import com.example.recruitmenttrinity.ui.main.detail.DetailUserActivity

 class MainActivity : AppCompatActivity() {

     private lateinit var viewModel: MainViewModel
     private lateinit var binding: ActivityMainBinding
     private lateinit var loadingDialog: ProgressDialog

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)
         loadingDialog = ProgressDialog(this)

         initViewModel()
         initView()
     }

     private fun initView() {
         onShowLoading()
         viewModel.requestUser()
     }

     private fun initViewModel() {
         viewModel = ViewModelProvider(this)[MainViewModel::class.java]

         viewModel.responseUser().observe(this) {
             onDismissLoading()
             if (it != null) {
                 val itemClick = object : MainAdapter.OnItemClickListener {
                     override fun onItemClick(user: ResponseUser) {
                         DetailUserActivity.data = user
                         startActivity(Intent(this@MainActivity, DetailUserActivity::class.java))
                     }
                 }
                 val mainAdapter = MainAdapter(it, itemClick)
                 binding.recyclerUser.setHasFixedSize(true)
                 binding.recyclerUser.layoutManager = LinearLayoutManager(this)
                 binding.recyclerUser.adapter = mainAdapter
             } else {
                 Toast.makeText(this, "Tidak ada data = $it", Toast.LENGTH_SHORT).show()
             }
         }
     }

     private fun onShowLoading() {
         if(!loadingDialog.isShowing){
             loadingDialog.setMessage("Loading..")
             loadingDialog.setCancelable(false)
             loadingDialog.show()
         }
     }

     private fun onDismissLoading() {
         if(loadingDialog.isShowing) loadingDialog.dismiss()
     }

 }