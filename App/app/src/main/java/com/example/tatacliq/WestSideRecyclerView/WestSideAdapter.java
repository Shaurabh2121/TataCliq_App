package com.example.tatacliq.WestSideRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.HomeClickLister;
import com.example.tatacliq.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class WestSideAdapter extends RecyclerView.Adapter<WestSideViewHolder> {

    private ArrayList<WestsideItemClass> westsideItemClassList;
    private HomeClickLister homeClickLister;

    public WestSideAdapter(ArrayList<WestsideItemClass> westsideItemClassList,HomeClickLister homeClickLister) {
        this.westsideItemClassList = westsideItemClassList;
        this.homeClickLister=homeClickLister;
    }

    @NonNull
    @Override
    public WestSideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.westside_item_layout,parent,false);
        return new WestSideViewHolder(view,homeClickLister);
    }

    @Override
    public void onBindViewHolder(@NonNull WestSideViewHolder holder, int position) {

        WestsideItemClass westsideItemClass=westsideItemClassList.get(position);
        holder.setData(westsideItemClass);
    }

    @Override
    public int getItemCount() {
        return westsideItemClassList.size();
    }
}
