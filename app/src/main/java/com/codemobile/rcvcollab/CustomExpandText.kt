package com.codemobile.rcvcollab

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomExpandText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    companion object {
        private const val DEFAULT_IS_EXPAND = false
        private const val DEFAULT_MAX_LINE = 3
        private const val DEFAULT_EXPAND_TEXT = "... See More"
        private const val DEFAULT_EXPAND_Color = Color.BLUE
    }

    var onStateChangeListener: (CustomExpandText.(oldState2: Boolean, newState2: Boolean) -> Unit)? =
        null

    private var isExpand = DEFAULT_IS_EXPAND
        set(value) {
            if (field != value) {
                onStateChangeListener?.let { it(field, value) }
                field = value
            }
            updateText()
        }
    private var expandMaxLine: Int = DEFAULT_MAX_LINE
    private var expandMoreText: String = DEFAULT_EXPAND_TEXT
    private var expandMoreColor: Int = DEFAULT_EXPAND_Color
    private var originalText: CharSequence? = null

    init {
        initAttribute(context, attrs)
        setOnClickListener {
            isExpand = !isExpand
            updateText()
        }
    }

    fun setMaxLine(limitLine: Int) {
        expandMaxLine = limitLine
    }

    fun setExpandMoreText(text: String) {
        expandMoreText = text
    }

    fun setExpandMoreColor(color: Int) {
        expandMoreColor = color
    }

    fun setExpandableText(text: CharSequence?) {
        originalText = text
        this.post {
            updateText()
        }
    }

    private fun updateText() {
        if (isExpand) {
            maxLines = Int.MAX_VALUE //set to control when user scroll
            makeTextViewResizable(Int.MAX_VALUE)
        } else {
            maxLines = expandMaxLine //set to control when user scroll
            makeTextViewResizable(expandMaxLine)
        }
    }

    private fun makeTextViewResizable(maxLine: Int) {
        val textView = this
        when {
            textView.lineCount >= maxLine -> {
                val expandText = expandMoreText
                val lineEndIndex = textView.layout.getLineEnd(maxLine - 1)
                val wordDefault = if (lineEndIndex <= expandText.length) {
                    textView.text.subSequence(0, lineEndIndex - 1).toString()
                } else {
                    textView.text.subSequence(
                        0,
                        lineEndIndex - expandText.length + 1
                    ).toString()
                }
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
            expandMoreText = it.getString(
                R.styleable.ExpandableTextView_expandableText
            ) ?: DEFAULT_EXPAND_TEXT
            expandMoreColor = it.getInt(
                R.styleable.ExpandableTextView_expandableColorText,
                DEFAULT_EXPAND_Color
            )
            it.recycle()
        }
    }
}