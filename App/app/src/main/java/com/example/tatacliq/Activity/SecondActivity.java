package com.example.tatacliq.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.tatacliq.Fragment.BrandsFragment;
import com.example.tatacliq.Fragment.CategoriesFragment;
import com.example.tatacliq.Fragment.HomeFragment;
import com.example.tatacliq.Fragment.HomeFragmentInsideWebView;
import com.example.tatacliq.Fragment.MyAccountFragment;
import com.example.tatacliq.Fragment.MyBagFragment;
import com.example.tatacliq.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {
    private BottomNavigationView bnv;
//    private FragmentManager mFragmentListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bnv = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new HomeFragment()).commit();
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp = null;
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        temp = new HomeFragment();
                        break;
                    case R.id.menu_categories:
                        temp = new CategoriesFragment();
                        break;
                    case R.id.menu_brand:
                        temp = new BrandsFragment();
                        break;
                    case R.id.menu_my_account:
                        temp = new MyAccountFragment();
                        break;
                    case R.id.menu_my_bags:
                        temp = new MyBagFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, temp).commit();
                return true;
            }
        });
//        mFragmentListener=getSupportFragmentManager();
//        launchFragmentBrandWebView();

    }

//    private void launchFragmentBrandWebView() {
//        HomeFragmentInsideWebView homeFragmentInsideWebView=new HomeFragmentInsideWebView();
//        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, homeFragmentInsideWebView, "HomeFragmentWebView").addToBackStack("HomeFragmentWebView").commit();
//    }
}