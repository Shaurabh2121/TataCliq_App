package com.example.tatacliq.WestSideRecyclerView;

import android.content.pm.LauncherApps;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.R;

public class WestSideViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvWestSide;
    private TextView mTvWestSide;


    public WestSideViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View itemView) {

        mIvWestSide=itemView.findViewById(R.id.ivWestSide);
        mTvWestSide=itemView.findViewById(R.id.tvWestSide);
    }

    public void setData(WestsideItemClass westsideItemClass){

        mTvWestSide.setText(westsideItemClass.getCategoryText());
        mIvWestSide.setImageResource(westsideItemClass.getImage());
    }
}
