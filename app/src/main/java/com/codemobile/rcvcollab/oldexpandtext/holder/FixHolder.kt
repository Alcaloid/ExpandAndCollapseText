package com.codemobile.rcvcollab.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codemobile.rcvcollab.TextMakeResize
import kotlinx.android.synthetic.main.staticboxholder.view.*

class FixHolder (view: View) : RecyclerView.ViewHolder(view) {
    val textData: TextMakeResize = view.txtResize
}