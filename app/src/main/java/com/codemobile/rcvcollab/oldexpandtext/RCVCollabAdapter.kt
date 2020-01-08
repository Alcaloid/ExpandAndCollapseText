package com.codemobile.rcvcollab.oldexpandtext

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codemobile.rcvcollab.R
import com.codemobile.rcvcollab.oldexpandtext.datatype.BaseDataType
import com.codemobile.rcvcollab.oldexpandtext.datatype.CloneType
import com.codemobile.rcvcollab.oldexpandtext.datatype.CrazyType
import com.codemobile.rcvcollab.oldexpandtext.holder.CloneARMISIXHolder
import com.codemobile.rcvcollab.oldexpandtext.holder.FixHolder
import com.codemobile.rcvcollab.oldexpandtext.holder.StartWarHolder


class PeopleRecycleViewAdapter(val context: Context, val mDataArray: ArrayList<BaseDataType>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (mDataArray[position]) {
            is CrazyType -> {
                1
            }
            is CloneType -> {
                0
            }
            else -> {
                1
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                CloneARMISIXHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_clone_armisix_edit_text,
                        parent,
                        false
                    )
                )
            }
            1 -> {
                FixHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.staticboxholder,
                        parent,
                        false
                    )
                )
            }
            else -> {
                //Empty
                StartWarHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.starwarholder,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return mDataArray.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> {
                val viewHolder = holder as CloneARMISIXHolder
                val fixArray = mDataArray[position] as CloneType
                viewHolder.textData.setExpandableText(fixArray.cloneText)
                viewHolder.setIsRecyclable(false)
                viewHolder.bindPosition(position,fixArray.focus){
                    newState, position ->
                    fixArray.focus  = newState
                    mDataArray[position] = fixArray
                }
            }
            1 -> {
                val viewHolder = holder as FixHolder
                val fixArray = mDataArray[position] as CrazyType
                viewHolder.textData.setExpandableText(fixArray.crazyText)
            }
            else -> {
                //Empty
            }
        }
    }
}