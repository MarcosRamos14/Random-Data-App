package com.example.randomdataapp.ui.details.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.randomdataapp.ui.details.DetailsAdapterItem

abstract class DetailsBaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: DetailsAdapterItem)
}