package com.codemobile.rcvcollab.oldexpandtext.holder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.codemobile.rcvcollab.armisix.CloneArmisixExpandText
import kotlinx.android.synthetic.main.item_clone_armisix_edit_text.view.txt_clone_ARMISIX_expand_text

class CloneARMISIXHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textData: CloneArmisixExpandText = view.txt_clone_ARMISIX_expand_text
    fun bindPosition(
        position: Int,
        state2: Boolean,
        onUpdate: (newState: Boolean, position: Int) -> Unit
    ) {
        Log.d("dfdfdf", "in:${position}")
        textData.onStateChangeListener = { oldState2, newState2 ->
            onUpdate.invoke(newState2, position)
        }
        textData.isExpand = state2
    }
}