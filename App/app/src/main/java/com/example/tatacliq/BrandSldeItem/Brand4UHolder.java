package com.example.tatacliq.BrandSldeItem;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.R;

public class Brand4UHolder extends RecyclerView.ViewHolder {
    private ImageView mIv;
    public Brand4UHolder(@NonNull View itemView) {
        super(itemView);
        mIv=itemView.findViewById(R.id.ivBrandForYou);
    }
    public void setBrand4UData(Brand4uModel brand4uModel){
        mIv.setImageResource(brand4uModel.getImage());
    }
}
