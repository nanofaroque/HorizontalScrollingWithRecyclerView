package com.nanofaroque.horizontalscrolling;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nanofaroque.horizontalscrolling.R.id.iv_cell;

/**
 * Created by omarfaroque on 3/7/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List ids;
    WeakReference<Activity> mActivity;
    public static MyItemClickCallback myItemClickCallback;

    public MyAdapter(ArrayList ids, Activity activity) {
        this.ids = ids;
        ids.add(0, new Integer(R.mipmap.blank_image));
        mActivity = new WeakReference<Activity>(activity);
        myItemClickCallback = (MyItemClickCallback) activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image_cell, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ivCell.setImageResource((Integer) ids.get(position));
    }

    @Override
    public int getItemCount() {
        return ids.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(iv_cell)
        public ImageView ivCell;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            ivCell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getLayoutPosition();
                    switch (pos) {
                        case 0:
                            myItemClickCallback.addImage();
                            break;
                        default:
                            myItemClickCallback.showImage();
                            break;
                    }
                }
            });
        }
    }
}
