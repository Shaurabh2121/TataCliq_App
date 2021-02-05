package com.example.tatacliq.PersonalBasicsStuffs;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.R;

public class PersonalBasicViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvStuff;
    private TextView mTvName;
    private TextView mTvDescription;
    private TextView mTvDescriptionTwo;
    private TextView mTvExplore;

    public PersonalBasicViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View itemView) {

        mIvStuff=itemView.findViewById(R.id.ivBasicStuffs);
        mTvName=itemView.findViewById(R.id.tvStuffsName);
        mTvDescription=itemView.findViewById(R.id.tvStuffDescription);
        mTvDescriptionTwo=itemView.findViewById(R.id.tvStuffDescriptionTwo);
        mTvExplore=itemView.findViewById(R.id.tvExplore);

    }

    public void setBasicStuffData(PersonalBasicStuffs personalBasicStuffs){

        mIvStuff.setImageResource(personalBasicStuffs.getBasicStuffs());
        mTvName.setText(personalBasicStuffs.getName());
        mTvDescription.setText(personalBasicStuffs.getDescription());
        mTvDescriptionTwo.setText(personalBasicStuffs.getDescriptionTwo());
        mTvExplore.setText(personalBasicStuffs.getExplore());

    }
}
