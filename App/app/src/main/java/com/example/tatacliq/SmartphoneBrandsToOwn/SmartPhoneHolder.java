package com.example.tatacliq.SmartphoneBrandsToOwn;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatacliq.R;

public class SmartPhoneHolder extends RecyclerView.ViewHolder {
    private ImageView mivSmartPhone;
    public SmartPhoneHolder(@NonNull View itemView) {
        super(itemView);
        mivSmartPhone=itemView.findViewById(R.id.ivSmartPhone);
    }
    public void setSmartPhoneImage(SmartphoneModel smartphoneModel){
        mivSmartPhone.setImageResource(smartphoneModel.getImage());
    }
}
