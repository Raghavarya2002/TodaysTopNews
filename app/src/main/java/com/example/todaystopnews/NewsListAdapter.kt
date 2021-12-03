package com.example.todaystopnews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter(private val items: ArrayList<String> , private val listener : NewsItemclicked) :
    RecyclerView.Adapter<NewsviewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewholder = NewsviewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewholder.adapterPosition])
        }
        return viewholder

    }

    override fun onBindViewHolder(holder: NewsviewHolder, position: Int) {

        val currentitem = items[position]
        holder.titleView.text = currentitem

    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class NewsviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.title)
    val recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerview)
}

interface NewsItemclicked{
    fun onItemClicked(items: String)
}