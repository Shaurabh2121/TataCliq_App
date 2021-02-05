package com.example.tatacliq.PersonalBasicsStuffs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.R;

import java.util.List;

public class PersonalBasicAdapter extends RecyclerView.Adapter<PersonalBasicViewHolder> {

    private List<PersonalBasicStuffs> personalBasicStuffsList;

    public PersonalBasicAdapter(List<PersonalBasicStuffs> personalBasicStuffsList) {
        this.personalBasicStuffsList = personalBasicStuffsList;
    }

    @NonNull
    @Override
    public PersonalBasicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.personal_basic_stuff_item_layout,parent,false);
        return new PersonalBasicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalBasicViewHolder holder, int position) {
PersonalBasicStuffs personalBasicStuffs=personalBasicStuffsList.get(position);
holder.setBasicStuffData(personalBasicStuffs);
    }

    @Override
    public int getItemCount() {
        return personalBasicStuffsList.size();
    }
}
