package com.example.tatacliq.BrandSldeItem;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.R;

import com.makeramen.roundedimageview.RoundedImageView;

public class BrandSlideHolder extends RecyclerView.ViewHolder {
    private RoundedImageView mIvRound;
    public BrandSlideHolder(@NonNull View itemView) {
        super(itemView);
        mIvRound=itemView.findViewById(R.id.brandRoundedImageView);
    }
    public void setBrandSlideImage(BrandSlideModel brandSlideModel){

        mIvRound.setImageResource(brandSlideModel.getImage());
    }
}
