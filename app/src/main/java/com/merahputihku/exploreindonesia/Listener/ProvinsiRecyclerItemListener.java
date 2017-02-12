package com.merahputihku.exploreindonesia.Listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by doy on 2/11/17.
 */

public class ProvinsiRecyclerItemListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
    }

    GestureDetector mGestureDetector;

    public ProvinsiRecyclerItemListener(Context context, OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
//                return super.onSingleTapUp(e);
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View mChildView = rv.findChildViewUnder(e.getX(), e.getY());
        if (mChildView != null && mOnItemClickListener!= null && mGestureDetector.onTouchEvent(e)){
            mOnItemClickListener.onItemClick(mChildView, rv.getChildPosition(mChildView));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
