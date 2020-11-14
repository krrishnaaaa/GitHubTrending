package com.pcsalt.example.githubtrending.util

import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DividerDecorator : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val childLayoutPosition = parent.getChildLayoutPosition(view)

        val margin = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 14f,
            parent.context.resources.displayMetrics
        ).toInt()
        when {
            childLayoutPosition > 0 -> outRect.top = margin / 2
            else -> outRect.top = margin
        }

        outRect.bottom = margin / 2
    }
}