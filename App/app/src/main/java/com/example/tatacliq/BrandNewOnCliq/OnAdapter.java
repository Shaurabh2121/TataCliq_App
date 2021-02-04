package com.example.tatacliq.BrandNewOnCliq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.R;

import java.util.List;

public class OnAdapter extends RecyclerView.Adapter<OnHolder> {
    private List<OnResponseModel>onResponseModelList;

    public OnAdapter(List<OnResponseModel> onResponseModelList) {
        this.onResponseModelList = onResponseModelList;
    }

    @NonNull
    @Override
    public OnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_on_new_cliq,parent,false);
        return new OnHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnHolder holder, int position) {
        holder.setBrandNewOnCliqImage(onResponseModelList.get(position));

    }

    @Override
    public int getItemCount() {
        return onResponseModelList.size();
    }
}
