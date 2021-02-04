package com.example.tatacliq.BrandSldeItem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.R;

import java.util.List;

public class Brand4UAdapter extends RecyclerView.Adapter<Brand4UHolder> {
    private List<Brand4uModel> brand4uModelList;

    public Brand4UAdapter(List<Brand4uModel> brand4uModelList) {
        this.brand4uModelList = brand4uModelList;
    }

    @NonNull
    @Override
    public Brand4UHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_for_you_item_layout,parent,false);
        return new Brand4UHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Brand4UHolder holder, int position) {
      holder.setBrand4UData(brand4uModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return brand4uModelList.size();
    }
}
