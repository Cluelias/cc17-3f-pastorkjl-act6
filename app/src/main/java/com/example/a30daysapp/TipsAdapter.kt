package com.example.a30daysapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ViewFlipper

class TipsAdapter(private val tipsList: List<Tip>, private val isDarkMode: Boolean) :
    RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayText: TextView = view.findViewById(R.id.dayText)
        val tipTitle: TextView = view.findViewById(R.id.tipTitle)
        val tipText: TextView = view.findViewById(R.id.tipText)
        val tipImage: ImageView = view.findViewById(R.id.tipImage)
        val extraTipText: TextView = view.findViewById(R.id.extraTipText)
        val cardView: CardView = view.findViewById(R.id.cardView)
        val viewFlipper: ViewFlipper = view.findViewById(R.id.viewFlipper)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tip_item, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tipsList[position]
        holder.dayText.text = "||== Day ${tip.day} ==||"
        holder.tipTitle.text = tip.tipTitle
        holder.tipText.text = tip.tipText
        holder.tipImage.setImageResource(tip.tipImage)
        holder.extraTipText.text = tip.extraTip

        if (isDarkMode) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#333333"))
            holder.dayText.setTextColor(Color.parseColor("#FFFFFF"))
            holder.tipTitle.setTextColor(Color.parseColor("#FFFFFF"))
            holder.tipText.setTextColor(Color.parseColor("#CCCCCC"))
            holder.extraTipText.setTextColor(Color.parseColor("#BBBBBB"))
        } else {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#F1F9FF"))
            holder.dayText.setTextColor(Color.parseColor("#FF6F61"))
            holder.tipTitle.setTextColor(Color.parseColor("#2c2a63"))
            holder.tipText.setTextColor(Color.parseColor("#6A5ACD"))
            holder.extraTipText.setTextColor(Color.parseColor("#2E2E2E"))
        }

        holder.tipImage.alpha = 0f
        holder.tipImage.animate().alpha(1f).setDuration(1000).start()

        holder.viewFlipper.setOnClickListener {
            holder.viewFlipper.showNext()
        }
    }

    override fun getItemCount(): Int = tipsList.size
}
