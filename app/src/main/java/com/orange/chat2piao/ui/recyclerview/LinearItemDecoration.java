package com.orange.chat2piao.ui.recyclerview;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class LinearItemDecoration extends RecyclerView.ItemDecoration {
    public static final int ORITATION_H = 0x001;
    public static final int ORITATION_V = 0x002;
    public static final int ORITATION_BOTH = 0x003;
    private int spacing;
    private boolean includeEdge;//水平或垂直
    private int oritation = ORITATION_V;
    private int secondSpacing = -1;//垂直（both下）

    public LinearItemDecoration(int spacing, boolean includeEdge, int oritation) {
        this.spacing = spacing;
        this.includeEdge = includeEdge;
        this.oritation = oritation;
    }

    public LinearItemDecoration(int spacing, int secondSpacing, boolean includeEdge) {
        oritation = ORITATION_BOTH;
        this.spacing = spacing;
        this.secondSpacing = secondSpacing;
        this.includeEdge = includeEdge;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        boolean isLast = position == parent.getChildCount() - 1;
        if (0 == position && !includeEdge) return;
        if (ORITATION_H == this.oritation) {
            outRect.left = spacing;
            if (isLast && includeEdge)
                outRect.right = spacing;
        } else if (ORITATION_V == this.oritation) {
            outRect.top = spacing;
            if (isLast && includeEdge)
                outRect.bottom = spacing;
        } else {
            outRect.left = spacing;
            outRect.top = secondSpacing;
            if (isLast && includeEdge) {
                outRect.right = spacing;
                outRect.bottom = secondSpacing;
            }
        }
    }
}
