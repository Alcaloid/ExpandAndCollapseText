package com.codemobile.rcvcollab

import android.content.Context
import android.graphics.Color
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatTextView

class ExpandAndCollapseText : AppCompatTextView {

    companion object {
        private const val DEFAULT_SUFFIX_MORE_TEXT = "[...more]"
        private const val DEFAULT_SUFFIX_LESS_TEXT = "[ less...]"
    }

    private val allText: String by lazy { text.toString() }
    private var suffixMoreInit = ""
    private var suffixLessInit = ""
    private var maxLinesInit = 0
    private var readMore = false

    var onStateChangeListener: (ExpandAndCollapseText.(oldState2: ExpandState, newState2: ExpandState) -> Unit)? =
        null

    var state = ExpandState.Collapsed
        set(value) {
            if (field != value) {
                Log.d("ExpandableTextView", "$field -> $value")
                onStateChangeListener?.let { it(field, value) }
                field = value
            }
            checkState()

        }

    val listenerClick = object : ClickableSpan() {
        override fun onClick(p0: View) {
            Log.d("ExpandableTextView", "click:${state}")
            when (state) {
                ExpandState.Collapsed -> {
                    state = ExpandState.Expanded
                }
                ExpandState.Expanded -> {
                    state = ExpandState.Collapsed
                }
                else -> {
                    state = ExpandState.Collapsed
                }
            }
        }

        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            when (state) {
                ExpandState.Collapsed -> {
                    ds.color = Color.RED
                    ds.isUnderlineText = false
                }
                ExpandState.Expanded -> {
                    ds.color = Color.GREEN
                    ds.isUnderlineText = false
                }
                else -> {
                    ds.color = Color.RED
                    ds.isUnderlineText = false
                }
            }
        }
    }

    constructor(context: Context) : super(context) {
        initAttrs()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initAttrs(attrs, defStyleAttr)
    }

    fun initAttrs(
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
    ) {
        super.setEllipsize(TextUtils.TruncateAt.END)
        context.obtainStyledAttributes(
            attrs,
            R.styleable.ExpandableTextView,
            defStyleAttr,
            defStyleRes
        ).apply {
            maxLinesInit = maxLines
            suffixMoreInit =
                getString(R.styleable.ExpandableTextView_etv_ellipsize_more_text)
                    ?: DEFAULT_SUFFIX_MORE_TEXT
            suffixLessInit =
                getString(R.styleable.ExpandableTextView_etv_ellipsize_less_text)
                    ?: DEFAULT_SUFFIX_LESS_TEXT
        }.recycle()
    }

    fun checkState() {
        Log.d("ExpandableTextView", "checkState:${state}")
        when (state) {
            ExpandState.Collapsed -> {
                maxLines = maxLinesInit
                readMore = false
                setCollapseText(maxLines, suffixMoreInit)
            }
            ExpandState.Expanded -> {
                maxLines = Int.MAX_VALUE
                readMore = true
                text = allText
                setExpandText(suffixLessInit)
            }
            else -> {
                maxLines = maxLinesInit
                readMore = false
                setCollapseText(maxLines, suffixMoreInit)
            }
        }
    }

    private fun setCollapseText(limitLine: Int, readMoreText: String) {
        val vto = viewTreeObserver
        vto.addOnGlobalLayoutListener {
            Log.d("ExpandableTextView", "LineCount:${lineCount}, ReadMore:${readMore}")
            Log.d("ExpandableTextView", "MaxLine:${maxLines}")
            if (lineCount >= limitLine && state == ExpandState.Collapsed && !readMore) {
                Log.d("ExpandableTextView", "Coming!")
                resizeTextOverLimit(limitLine, readMoreText)
            }
        }
    }

    private fun resizeTextOverLimit(limitLine: Int, readMoreText: String) {
        val lineEndIndex = layout.getLineEnd(limitLine - 1)
        Log.d("ExpandableTextView", "LineEndAfter:${lineEndIndex}")
        val indexStartSpan = lineEndIndex - readMoreText.length - 1
        Log.d("ExpandableTextView", "indexSpan:${indexStartSpan}")
        Log.d("ExpandableTextView", "allText:${allText}")
        Log.d("ExpandableTextView", "allTextLength:${allText.length}")
        val newTextResize = text.subSequence(
            0, indexStartSpan
        ).toString() + readMoreText
        Log.d("ExpandableTextView", "newText:${newTextResize}")
        Log.d("ExpandableTextView", "newTextLength:${newTextResize.length}")
        setSpanText(indexStartSpan, readMoreText.length, newTextResize)
    }

    private fun setSpanText(indexSpan: Int, indexSpanText: Int, data: String) {
        val span = SpannableString(data)
        movementMethod = LinkMovementMethod.getInstance()
        span.setSpan(
            listenerClick,
            indexSpan,
            indexSpan + indexSpanText,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        setText(span, BufferType.SPANNABLE)
    }

    private fun setExpandText(readLessText: String) {
        val newText = allText + readLessText
        val spannable = SpannableString(newText)
        text = null

        Log.d("ExpandableTextView", "collap--${newText}")

        spannable.setSpan(
            listenerClick,
            newText.length - readLessText.length,
            newText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        setText(spannable, BufferType.SPANNABLE)
        movementMethod = LinkMovementMethod.getInstance()
        setLinkTextColor(Color.GREEN)

    }
}