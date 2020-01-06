package com.codemobile.rcvcollab.oldexpandtext.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.codemobile.rcvcollab.oldexpandtext.TextMakeResize
import kotlinx.android.synthetic.main.staticboxholder.view.*

class FixHolder (view: View) : RecyclerView.ViewHolder(view) {
    val textData: TextMakeResize = view.txtResize
}