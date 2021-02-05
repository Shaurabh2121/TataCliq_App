package com.example.tatacliq.SmartphoneBrandsToOwn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.R;

import java.util.List;

public class SmartPhoneAdapter extends RecyclerView.Adapter<SmartPhoneHolder> {
    private List<SmartphoneModel>smartphoneModelList;

    public SmartPhoneAdapter(List<SmartphoneModel> smartphoneModelList) {
        this.smartphoneModelList = smartphoneModelList;
    }

    @NonNull
    @Override
    public SmartPhoneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.smartphone_brand_to_own,parent,false);
        return new SmartPhoneHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SmartPhoneHolder holder, int position) {
holder.setSmartPhoneImage(smartphoneModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return smartphoneModelList.size();
    }
}
