package com.codemobile.rcvcollab.armisix

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import com.codemobile.rcvcollab.R

class ExpandableTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    companion object {
        private const val DEFAULT_IS_EXPAND = false
        private const val DEFAULT_MAX_LINE = 3
    }

    private var isExpand = DEFAULT_IS_EXPAND
    private var expandMaxLine: Int = DEFAULT_MAX_LINE
    private var originalText: CharSequence? = null

    init {
        initAttribute(context, attrs)
        setExpandableText(text)
        setOnClickListener {
            isExpand = !isExpand
            updateText()
        }
    }

    fun setExpandableText(text: CharSequence?) {
        originalText = text
        this.post {
            updateText()
        }
    }

    private fun updateText() {
        if (isExpand) {
            makeTextViewResizable(Int.MAX_VALUE)
        } else {
            makeTextViewResizable(expandMaxLine)
        }
    }

    private fun makeTextViewResizable(maxLine: Int) {
        val textView = this
        when {
            textView.lineCount >= maxLine -> {
                val expandText = "... SeeMore"
                val lineEndIndex = textView.layout.getLineEnd(maxLine - 1)

                val wordDefault = SpannableString(
                    textView.text.subSequence(0, lineEndIndex - expandText.length + 1).toString()
                )
                val wordMore = SpannableString(expandText).also {
                    it.setSpan(
                        ForegroundColorSpan(Color.BLUE),
                        0,
                        it.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }

                textView.text = wordDefault
                textView.append(wordMore)
            }
            else -> {
                textView.text = originalText
            }
        }
    }

    @SuppressLint("Recycle")
    private fun initAttribute(context: Context, attrs: AttributeSet?) {
        context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView).also {
            expandMaxLine =
                it.getInt(R.styleable.ExpandableTextView_expandableMaxLine, DEFAULT_MAX_LINE)
            isExpand =
                it.getBoolean(R.styleable.ExpandableTextView_expandableIsExpand, DEFAULT_IS_EXPAND)
            it.recycle()
        }
    }
}