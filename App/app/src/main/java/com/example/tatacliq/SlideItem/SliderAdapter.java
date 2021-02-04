package com.example.tatacliq.SlideItem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tatacliq.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderHolder> {

    private List<SliderItem> sliderItemList;
    private ViewPager2 viewPager2;

    public SliderAdapter(List<SliderItem> sliderItemList, ViewPager2 viewPager2) {
        this.sliderItemList = sliderItemList;
        this.viewPager2 = viewPager2;
    }


    @NonNull
    @Override
    public SliderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_item_container,parent,false);
        return new SliderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderHolder holder, int position) {
        SliderItem sliderItem=sliderItemList.get(position);
        holder.setSlideImage(sliderItem);
        if (position==sliderItemList.size()-2){
            viewPager2.post(runnable);
        }

    }

    @Override
    public int getItemCount() {
        return sliderItemList.size();
    }

    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            sliderItemList.addAll(sliderItemList);
            notifyDataSetChanged();
        }
    };
}
