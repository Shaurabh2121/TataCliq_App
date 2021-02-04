package com.example.tatacliq.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tatacliq.R;


public class MyAccountFragment extends Fragment {

        private EditText metEmail, metPassword;
        private Button mbtnFb, mbtnGoogle, mbtnLogin, mbtnTataCliq;
        private TextView mtvForgetPassword, mtvSignSocialAccount, mtvCallus, mtvTAndCondition;


        public MyAccountFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_my_account, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            initView(view);
        }

        private void initView(View view) {
            metEmail = view.findViewById(R.id.etEmail);
            metPassword = view.findViewById(R.id.etPassword);
            mbtnFb = view.findViewById(R.id.btnFb);
            mbtnGoogle = view.findViewById(R.id.btnGoogle);
            mbtnLogin = view.findViewById(R.id.btnLogin);
            mbtnTataCliq = view.findViewById(R.id.btnNewTataCliq);
            mtvForgetPassword = view.findViewById(R.id.tvForgetPass);
            mtvCallus = view.findViewById(R.id.tvCallUs);
            mtvTAndCondition = view.findViewById(R.id.tvTAndCondition);
            mtvSignSocialAccount = view.findViewById(R.id.tvSignSocialAccount);
        }
    }
