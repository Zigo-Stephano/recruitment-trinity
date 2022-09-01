package com.example.recruitmenttrinity.ui.main.detail

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.recruitmenttrinity.R
import com.example.recruitmenttrinity.data.model.ResponseUser
import com.example.recruitmenttrinity.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var viewModel: DetailUserViewModel
    private lateinit var loadingDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadingDialog = ProgressDialog(this)

        initViewModel()
        initView()

    }

    private fun initView() {
        binding.etFirstName.setText(data?.firstname.toString())
        binding.etLastName.setText(data?.lastname.toString())
        binding.etEmail.setText(data?.email.toString())
        binding.etPhone.setText(data?.phone.toString())
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[DetailUserViewModel::class.java]
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

    companion object {
        var data: ResponseUser? = null
    }

}