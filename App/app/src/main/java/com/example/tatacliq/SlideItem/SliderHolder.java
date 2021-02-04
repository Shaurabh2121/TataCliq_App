package com.example.tatacliq.SlideItem;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.R;
import com.makeramen.roundedimageview.RoundedImageView;

public class SliderHolder extends RecyclerView.ViewHolder {

    private RoundedImageView mImage;

    public SliderHolder(@NonNull View itemView) {
        super(itemView);
        mImage=itemView.findViewById(R.id.imageSlide);
    }

    public void setSlideImage(SliderItem sliderItem){

        mImage.setImageResource(sliderItem.getImage());
    }
}
