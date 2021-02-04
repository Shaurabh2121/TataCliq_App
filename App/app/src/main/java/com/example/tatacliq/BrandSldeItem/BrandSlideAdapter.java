package com.example.tatacliq.BrandSldeItem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tatacliq.R;


import java.util.List;

public class BrandSlideAdapter extends RecyclerView.Adapter<BrandSlideHolder> {
    private List<BrandSlideModel>brandList;
    private ViewPager2 viewPager2;

    public BrandSlideAdapter(List<BrandSlideModel> brandList, ViewPager2 viewPager2) {
        this.brandList = brandList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public BrandSlideHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_slide_item_container,parent,false);
        return new BrandSlideHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandSlideHolder holder, int position) {
      BrandSlideModel brandSlideModel=brandList.get(position);
      holder.setBrandSlideImage(brandSlideModel);
        if (position==brandList.size()-2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            brandList.addAll(brandList);
            notifyDataSetChanged();
        }
    };
}
