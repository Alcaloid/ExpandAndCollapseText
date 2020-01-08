package com.codemobile.rcvcollab.oldexpandtext.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.codemobile.rcvcollab.armisix.ExpandableTextView
import com.codemobile.rcvcollab.oldexpandtext.TextMakeResize
import kotlinx.android.synthetic.main.staticboxholder.view.txtResize

class FixHolder (view: View) : RecyclerView.ViewHolder(view) {
    val textData: ExpandableTextView = view.txtResize
}