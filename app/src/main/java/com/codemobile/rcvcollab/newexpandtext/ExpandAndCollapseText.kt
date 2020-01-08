package com.codemobile.rcvcollab.newexpandtext

import android.content.Context
import android.graphics.Color
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.widget.AppCompatTextView
import com.codemobile.rcvcollab.R

class ExpandAndCollapseText : AppCompatTextView {

    companion object {
        private const val DEFAULT_SUFFIX_MORE_TEXT = "[...more]"
        private const val DEFAULT_SUFFIX_LESS_TEXT = "[ less...]"
        private const val DEFAULT_MAXLINE = 3
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
//                Log.d("ExpandableTextView", "$field -> $value")
                onStateChangeListener?.let { it(field, value) }
                field = value
            }
            checkState()

        }

    val listenerClick = object : ClickableSpan() {
        override fun onClick(p0: View) {
//            Log.d("ExpandableTextView", "click:${state}")
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
            ds.isUnderlineText = false
            when (state) {
                ExpandState.Collapsed -> {
                    ds.color = Color.RED
                }
                ExpandState.Expanded -> {
                    ds.color = Color.GREEN
                }
                else -> {
                    ds.color = Color.RED
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
        super.setMaxLines(Int.MAX_VALUE)
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
//        Log.d("ExpandableTextView", "checkState:${state}")
        when (state) {
            ExpandState.Collapsed -> {
                maxLines = maxLinesInit
                readMore = false
                setCollapseText(DEFAULT_MAXLINE, suffixMoreInit)
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
                setCollapseText(DEFAULT_MAXLINE, suffixMoreInit)
            }
        }
    }

//    fun setText

    private fun setCollapseText(limitLine: Int, readMoreText: String) {
        val vto = viewTreeObserver
//        vto.addOnGlobalLayoutListener(object :
//            ViewTreeObserver.OnGlobalLayoutListener {
//            override fun onGlobalLayout() {
//                text = allText
////                Log.d("ExpandableTextView", "Check!")
////                Log.d("ExpandableTextView", "LineCount:${lineCount}, ReadMore:${readMore}")
////                Log.d("ExpandableTextView", "MaxLine:${maxLines}")
//                if (lineCount >= limitLine && state == ExpandState.Collapsed && !readMore) {
////                    Log.d("ExpandableTextView", "Coming!")
//                    resizeTextOverLimit(limitLine, readMoreText)
//
//                }
//                viewTreeObserver.removeOnGlobalLayoutListener(this)
//            }
//        })
        vto.addOnScrollChangedListener(object :
            ViewTreeObserver.OnScrollChangedListener {
            override fun onScrollChanged() {
                Log.d("ExpandableTextView", "LineCount:${lineCount}, ReadMore:${readMore}")
                if (lineCount >= limitLine && state == ExpandState.Collapsed) {
                    Log.d("ExpandableTextView", "Coming!")
                    resizeTextOverLimit(limitLine, readMoreText)
                }
                viewTreeObserver.removeOnScrollChangedListener(this)
            }
        })


//        addOnLayoutChangeListener(object : OnLayoutChangeListener {
//            override fun onLayoutChange(
//                v: View?,
//                left: Int,
//                top: Int,
//                right: Int,
//                bottom: Int,
//                oldLeft: Int,
//                oldTop: Int,
//                oldRight: Int,
//                oldBottom: Int
//            ) {
//
//                Log.d("ExpandableTextView", "LineCount:${lineCount}, ReadMore:${readMore}")
//                Log.d("ExpandableTextView", "MaxLine:${maxLinesInit}")
//                if (lineCount >= limitLine && state == ExpandState.Collapsed && !readMore) {
//                    Log.d("ExpandableTextView", "Coming!")
//                    resizeTextOverLimit(limitLine, readMoreText)
//                }
//                removeOnLayoutChangeListener(this)
//            }
//        })
    }

//    fun setTextExpandingAndCollapse(fullText:String){
//        allText = fullText
//    }

    private fun resizeTextOverLimit(limitLine: Int, readMoreText: String) {
        val lineEndIndex = layout.getLineEnd(limitLine - 1)
        val indexStartSpan = lineEndIndex - readMoreText.length - 1
        val newTextResize = text.subSequence(
            0, indexStartSpan
        ).toString() + readMoreText
//        allText = text.toString() //save text
        Log.d("ExpandableTextView", "alltext:${allText}")
        Log.d("ExpandableTextView", "newtext:${newTextResize}")
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
//        Log.d("ExpandableTextView", "alltext:${allText}")
//        Log.d("ExpandableTextView", "newText_2:${newText}")
        val spannable = SpannableString(newText)
        text = null

//        Log.d("ExpandableTextView", "collap--${newText}")

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