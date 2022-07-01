package com.kotlinexamples.gotovorecipes.adapters

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
import com.kotlinexamples.gotovorecipes.data.drinks.Drink

class NewAdapter(drinkArray: ArrayList<Drink>, context: Context) :
    RecyclerView.Adapter<NewAdapter.ViewHolder>() {

    private var drinkArrayR = drinkArray
    private var contextR = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.id_content_main_image)
        private val tvTitle = view.findViewById<TextView>(R.id.id_content_name)

        fun bindContent(drink: Drink, context: Context) {
            image.setImageResource(drink.imageId)
            tvTitle.text = drink.name

            itemView.setOnClickListener {

                val intent = Intent(context, ContentActivity::class.java).apply {
                    putExtra("image", drink.imageId)
                    putExtra("title", drink.name)
                    putExtra("ingredients", drink.ingredients)
                    putExtra("recipe", drink.recipe)
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
        holder.bindContent(drinkArrayR[position], contextR)
    }

    override fun getItemCount(): Int {
        return drinkArrayR.size
    }


    fun updateNewAdapter(drinkArray: List<Drink>) {

    }
}