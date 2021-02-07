package com.example.tatacliq.WestSideRecyclerView;

import android.content.pm.LauncherApps;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.HomeClickLister;
import com.example.tatacliq.R;

public class WestSideViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvWestSide;
    private TextView mTvWestSide;
    private HomeClickLister homeClickLister;
    private LinearLayout mWishList;

    public WestSideViewHolder(@NonNull View itemView,HomeClickLister homeClickLister) {
        super(itemView);
        init(itemView);
        this.homeClickLister=homeClickLister;
    }

    private void init(View itemView) {

        mIvWestSide=itemView.findViewById(R.id.ivWestSide);
        mTvWestSide=itemView.findViewById(R.id.tvWestSide);
        mWishList=itemView.findViewById(R.id.wishList);
    }

    public void setData(WestsideItemClass westsideItemClass){

        mTvWestSide.setText(westsideItemClass.getCategoryText());
        mIvWestSide.setImageResource(westsideItemClass.getImage());
        mWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             homeClickLister.onClickedWishListed(westsideItemClass);
            }
        });
    }
}
