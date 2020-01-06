package com.codemobile.rcvcollab

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codemobile.rcvcollab.datatype.ExpandText

class RCVExpandTextAdapter(val context: Context, val mDataArray: ArrayList<ExpandText>) :
    RecyclerView.Adapter<ExpandViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpandViewHolder {
        return ExpandViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_text_epx,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return mDataArray.size
    }

    override fun onBindViewHolder(holder: ExpandViewHolder, position: Int) {
        holder.expText.text = mDataArray[position].dataString
        holder.bindPosition(position, mDataArray[position].dataState) { state, postion ->
            mDataArray[position].dataState = state
        }
    }
}