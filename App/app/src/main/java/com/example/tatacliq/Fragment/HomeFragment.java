package com.example.tatacliq.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tatacliq.R;
import com.example.tatacliq.SlideItem.SliderAdapter;
import com.example.tatacliq.SlideItem.SliderItem;
import com.example.tatacliq.WestSideRecyclerView.WestSideAdapter;
import com.example.tatacliq.WestSideRecyclerView.WestsideItemClass;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerWestSide;
    private ArrayList<WestsideItemClass> westsideItemClassList;
    private List<SliderItem> sliderItemList;
    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerWestSide = view.findViewById(R.id.recyclerWestSide);
        viewPager2 = view.findViewById(R.id.viewPagerImageSlider);
        setWestSideRecyclerAdapter();
        setWestSideRecyclerData();
        setSliderAdapter();
        setSliderData();
    }

    private void setSliderData() {
        viewPager2.setAdapter(new SliderAdapter(sliderItemList, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(15));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,3000);  //slider duration 3 second
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable,3000);
    }

    private void setSliderAdapter() {

        sliderItemList = new ArrayList<>();
        sliderItemList.add(new SliderItem(R.drawable.watch));
        sliderItemList.add(new SliderItem(R.drawable.sound));
        sliderItemList.add(new SliderItem(R.drawable.pillow));
        sliderItemList.add(new SliderItem(R.drawable.dryer));
        sliderItemList.add(new SliderItem(R.drawable.shoes));

    }

    private void setWestSideRecyclerData() {

        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        WestSideAdapter westSideAdapter = new WestSideAdapter(westsideItemClassList);
        mRecyclerWestSide.setLayoutManager(linearLayoutManager);
        mRecyclerWestSide.setAdapter(westSideAdapter);

    }

    private void setWestSideRecyclerAdapter() {

        westsideItemClassList = new ArrayList<>();

        westsideItemClassList.add(new WestsideItemClass("WESTSIDE", R.drawable.westside_image));
        westsideItemClassList.add(new WestsideItemClass("SMARTPHONES", R.drawable.smartphone));
        westsideItemClassList.add(new WestsideItemClass("FRAGRANCE", R.drawable.fragrance));
        westsideItemClassList.add(new WestsideItemClass("FOOTWEAR", R.drawable.footware));
        westsideItemClassList.add(new WestsideItemClass("ELECTRONIC", R.drawable.electronic));
        westsideItemClassList.add(new WestsideItemClass("WOMENWEAR", R.drawable.womenswear));
        westsideItemClassList.add(new WestsideItemClass("AUDIO", R.drawable.audio));
        westsideItemClassList.add(new WestsideItemClass("CLIQ LUXURY", R.drawable.luxury));
        westsideItemClassList.add(new WestsideItemClass("MENSWEAR", R.drawable.menswear));
        westsideItemClassList.add(new WestsideItemClass("APPLIANCES", R.drawable.appliances));
    }


}