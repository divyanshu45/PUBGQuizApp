package com.example.quizapp

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val context: Context, private val cards: List<Card>, val mOnClickListner: ListItemClickListner) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val description = itemView.findViewById<TextView>(R.id.desc)
        val descBottom = itemView.findViewById<TextView>(R.id.tv_description)
        val layout = itemView.findViewById<RelativeLayout>(R.id.rl_layout)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val clickedPos = adapterPosition
            mOnClickListner.onCardClick(clickedPos)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.mode_layout, parent, false))
    }

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]
        holder.description.text = card.desc
        holder.descBottom.text = card.bottomDesc
        holder.layout.setBackgroundResource(card.image)
    }

    interface ListItemClickListner{
        fun onCardClick(Index: Int)
    }
}

