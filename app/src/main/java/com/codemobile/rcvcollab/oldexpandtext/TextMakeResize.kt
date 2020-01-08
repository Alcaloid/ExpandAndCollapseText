package com.codemobile.rcvcollab.oldexpandtext

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.view.View
import android.widget.TextView

class TextMakeResize(context: Context, attrs: AttributeSet) : TextView(context, attrs) {

    private var spanTextColor = -0xffff01
    private var realText = text
    private var spanTextMore = "...[More]"
    private var spanTextLess = "[Less]"
    private var lessText = ""
    private var readMore = false
    private var limitLine = maxLines

    init {
        setup()
    }

    private fun setBasicData() {

    }

    fun setup() {
        val vto = viewTreeObserver
        vto.addOnGlobalLayoutListener {
            if (lineCount > limitLine && !readMore) {
                setLessText()
                resizeTextOverLimit()
            }
        }
        vto.addOnScrollChangedListener {
            if (lineCount > limitLine && !readMore) {
                setLessText()
                resizeTextOverLimit()
            }
        }
    }


    private fun resizeTextOverLimit() {
        val lineEndIndex = layout.getLineEnd(limitLine - 1)
        val indexStartSpan = lineEndIndex - spanTextMore.length
        val newTextResize = text.subSequence(
            0, indexStartSpan
        ).toString() + " " + spanTextMore
        setSpanText(indexStartSpan, spanTextMore.length, newTextResize)
    }

    private fun setSpanText(indexSpan: Int, indexSpanText: Int, data: String) {
        val span = SpannableString(data)
        movementMethod = LinkMovementMethod.getInstance()
        val dataClick = setSpanClickable()
        span.setSpan(
            dataClick,
            indexSpan,
            indexSpan + indexSpanText,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        setText(span, BufferType.SPANNABLE)
    }

    private fun setSpanClickable(): ClickableSpan {
        return object : ClickableSpan() {
            override fun onClick(widget: View) {
                if (!readMore) {
                    maxLines = Int.MAX_VALUE
                    setSpanText(realText.length, spanTextLess.length, lessText)
                } else {
                    maxLines = limitLine
                }
                readMore = !readMore
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = spanTextColor
                ds.isUnderlineText = false
            }
        }
    }

    fun setReadMore(focus:Boolean){
        readMore = focus
    }

    fun setSpanText(textMore: String, textLess: String) {
        spanTextMore = textMore
        spanTextLess = textLess
    }

    fun setSpanTextColor(idColor: Int) {
        spanTextColor = idColor
    }

    fun setTextResize(string: String) {
        realText = string
        text = string
        setLessText()
    }

    fun setCustomMaxLine(nLimitLine: Int) {
        maxLines = nLimitLine
        limitLine = nLimitLine
    }

    private fun setLessText() {
        lessText = "$realText $spanTextLess"
    }
}