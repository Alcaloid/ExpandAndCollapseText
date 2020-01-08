package com.codemobile.rcvcollab.newexpandtext

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codemobile.rcvcollab.R

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
        Log.d("ExpandableTextView", "Position${position}")
//        holder.setIsRecyclable(false)
        holder.expText.text = "position is ${position}\n" + mDataArray[position].dataString
        holder.bindPosition(position, mDataArray[position].dataState) { state, postion ->
            mDataArray[position].dataState = state
        }
    }

    override fun onViewRecycled(holder: ExpandViewHolder) {
        super.onViewRecycled(holder)
        Log.d("Recycler", "onRecycled: ${holder.layoutPosition}")
    }
}