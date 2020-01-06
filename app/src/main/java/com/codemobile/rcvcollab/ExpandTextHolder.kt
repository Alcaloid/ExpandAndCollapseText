package com.codemobile.rcvcollab

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_text_epx.view.txt_expand_collapse

class ExpandViewHolder(private val iv: View) : RecyclerView.ViewHolder(iv) {

    val expText = iv.txt_expand_collapse

    fun bindPosition(
        position: Int,
        state: ExpandState,
        onUpdate: (newState: ExpandState, position: Int) -> Unit
    ) {
        expText.onStateChangeListener = { oldState2, newState2 ->
            onUpdate.invoke(newState2, position)
        }
        expText.state = state
    }
}