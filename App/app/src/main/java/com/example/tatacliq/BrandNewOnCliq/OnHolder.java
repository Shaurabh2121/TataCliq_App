package com.example.tatacliq.BrandNewOnCliq;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.R;

public class OnHolder extends RecyclerView.ViewHolder {
    private ImageView mIvNo;
    public OnHolder(@NonNull View itemView) {
        super(itemView);
        mIvNo=itemView.findViewById(R.id.ivOn);
    }
    public void setBrandNewOnCliqImage(OnResponseModel onResponseModel){
        mIvNo.setImageResource(onResponseModel.getImage());
    }
}
