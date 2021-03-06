package com.merahputihku.exploreindonesia.Dekorasi;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by doy on 2/11/17.
 */

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public GridSpacingItemDecoration (int spanCount, int spacing, boolean includeEdge){
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int column = position % spanCount;

        if (includeEdge){
            outRect.left = spacing - column * spacing / spanCount;
            outRect.right = (column - 1) * spacing / spanCount;
            if (position < spanCount){
                outRect.top = spacing;
            }
            outRect.bottom = spacing;
        }
        else{
            outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing; // item top
            }
        }
        super.getItemOffsets(outRect, view, parent, state);
    }
}
