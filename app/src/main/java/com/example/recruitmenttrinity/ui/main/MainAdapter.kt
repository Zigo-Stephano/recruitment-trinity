package com.example.recruitmenttrinity.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recruitmenttrinity.R
import com.example.recruitmenttrinity.data.model.ResponseUser
import com.example.recruitmenttrinity.databinding.ItemUserBinding

class MainAdapter(
    private val users: MutableList<ResponseUser?>?,
    _onItemClickListener: OnItemClickListener
): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(user: ResponseUser)
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemUserBinding.bind(itemView)
    }

    private val listener = _onItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = users!![position]
        with(holder) {
            binding.tvUsername.text = "${user!!.firstname} ${user.lastname}"
            itemView.setOnClickListener {
                listener.onItemClick(users[holder.adapterPosition]!!)
            }
        }
    }

    override fun getItemCount() = users!!.size
}