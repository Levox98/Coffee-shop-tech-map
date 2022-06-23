package com.kotlinexamples.gotovorecipes.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kotlinexamples.gotovorecipes.ContentActivity
import com.kotlinexamples.gotovorecipes.R
import com.kotlinexamples.gotovorecipes.data.ListItem

class ContentAdapter(itemArray: ArrayList<ListItem>, context: Context) : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {
    var itemArrayR = itemArray
    var contextR = context


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.id_content_main_image)
        val tvTitle = view.findViewById<TextView>(R.id.id_content_name)

        fun bind(listItem: ListItem, context: Context) {
            image.setImageResource(listItem.imageId)
            tvTitle.text = listItem.titleText

            itemView.setOnClickListener() {
                Toast.makeText(context, "Pressed: ${tvTitle.text}", Toast.LENGTH_SHORT).show()

                val intent = Intent(context, ContentActivity::class.java).apply {
                    putExtra("image", listItem.imageId)
                    putExtra("title", listItem.titleText)
                    putExtra("ingredients", listItem.ingredientText)
                    putExtra("recipe", listItem.recipeText)
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

    fun updateAdapter(listArray: List<ListItem>) {
        itemArrayR.clear()
        itemArrayR.addAll(listArray)
        notifyDataSetChanged()
    }
}