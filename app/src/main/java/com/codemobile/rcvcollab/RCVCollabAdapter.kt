package com.codemobile.rcvcollab

import android.content.Context
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codemobile.rcvcollab.datatype.BaseDataType
import com.codemobile.rcvcollab.datatype.CrazyType
import com.codemobile.rcvcollab.holder.FixHolder
import com.codemobile.rcvcollab.holder.StartWarHolder


class PeopleRecycleViewAdapter(val context: Context, val mDataArray: ArrayList<BaseDataType>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                StartWarHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.starwarholder,
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

            }
            1 -> {
                val viewHolder = holder as FixHolder
                val fixArray = mDataArray[position] as CrazyType
                viewHolder.textData.setup()
                viewHolder.textData.setTextResize(fixArray.crazyText)
                viewHolder.textData.setReadMore(false)
                viewHolder.textData.setCustomMaxLine(5)
            }
            else -> {
                //Empty
            }
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)

    }
}