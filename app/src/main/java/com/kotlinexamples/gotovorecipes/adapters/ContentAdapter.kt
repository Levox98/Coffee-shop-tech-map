package com.kotlinexamples.gotovorecipes.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlinexamples.gotovorecipes.ContentActivity
import com.kotlinexamples.gotovorecipes.R
import com.kotlinexamples.gotovorecipes.data.Item

class ContentAdapter(itemArray: ArrayList<Item>, context: Context) : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {
    private var itemArrayR = itemArray
    private var contextR = context


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image= view.findViewById<ImageView>(R.id.id_content_main_image)
        private val tvTitle = view.findViewById<TextView>(R.id.id_content_name)

        fun bind(item: Item, context: Context) {
            image.setImageResource(item.imageId)
            tvTitle.text = item.titleText

            itemView.setOnClickListener {

                val intent = Intent(context, ContentActivity::class.java).apply {
                    putExtra("image", item.imageId)
                    putExtra("title", item.titleText)
                    putExtra("ingredients", item.ingredientText)
                    putExtra("recipe", item.recipeText)
                }

                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemArrayR[position], contextR)
    }

    override fun getItemCount(): Int {
        return itemArrayR.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(listArray: List<Item>) {
        itemArrayR.clear()
        itemArrayR.addAll(listArray)
        notifyDataSetChanged()
    }
}