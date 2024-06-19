package com.shruti.apipractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shruti.apipractice.R
import com.shruti.apipractice.db.UserItem

class UserAdapter(private val userList: UserItem) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvBody: TextView = itemView.findViewById(R.id.tvBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.tvTitle.text = currentItem.title
        holder.tvBody.text = currentItem.body

    }

    override fun getItemCount() = userList.size
}
