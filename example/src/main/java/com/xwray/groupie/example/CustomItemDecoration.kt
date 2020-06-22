package com.xwray.groupie.example

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CustomItemDecoration(private val leftPadding: Int = 0,
                           private val topPadding: Int = 0,
                           private val rightPadding: Int = 0,
                           private val bottomPadding: Int = 0) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = leftPadding
        outRect.top = topPadding
        outRect.right = rightPadding
        outRect.bottom = bottomPadding
    }
}