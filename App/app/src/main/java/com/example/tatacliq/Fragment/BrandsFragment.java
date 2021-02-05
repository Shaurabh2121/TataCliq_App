package com.example.tatacliq.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.tatacliq.BrandNewOnCliq.OnAdapter;
import com.example.tatacliq.BrandNewOnCliq.OnResponseModel;
import com.example.tatacliq.BrandSldeItem.Brand4UAdapter;
import com.example.tatacliq.BrandSldeItem.Brand4uModel;
import com.example.tatacliq.BrandSldeItem.BrandSlideAdapter;
import com.example.tatacliq.BrandSldeItem.BrandSlideModel;
import com.example.tatacliq.R;
import com.example.tatacliq.SlideItem.SliderAdapter;
import com.example.tatacliq.SlideItem.SliderItem;
import com.example.tatacliq.WestSideRecyclerView.WestSideAdapter;
import com.example.tatacliq.WestSideRecyclerView.WestsideItemClass;

import java.util.ArrayList;
import java.util.List;


public class BrandsFragment extends Fragment {
    private List<BrandSlideModel> brandSlideModelList;
    private ViewPager2 mviewPager2;
    private RecyclerView recyclerView;
    private Handler brandHandler = new Handler();
    private List<Brand4uModel>brand4uModelList;
    private Brand4UAdapter brand4UAdapter;
  private List<OnResponseModel>onResponseModelList;
  private OnAdapter onAdapter;
  private RecyclerView mRecyclerViewOn;
    public BrandsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brands, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mviewPager2=view.findViewById(R.id.viewPagerImageSliderBrand);
        recyclerView=view.findViewById(R.id.recyclerBrandForYou);
        mRecyclerViewOn=view.findViewById(R.id.recyclerBrandNewOnCliq);
        setBrandSliderAdapter();
        setBrandSliderData();
        buildBrand4uData();
        setRecyclerAdapterBrand4uData();
        buildBrandOnNewCliqData();
        setRecyclerAdapterBrandOnNewCliqData();

    }

    private void setRecyclerAdapterBrandOnNewCliqData() {
        GridLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),1,RecyclerView.HORIZONTAL,false);
        onAdapter=new OnAdapter(onResponseModelList);
        mRecyclerViewOn.setLayoutManager(linearLayoutManager);
        mRecyclerViewOn.setAdapter(onAdapter);
    }

    private void buildBrandOnNewCliqData() {
        onResponseModelList = new ArrayList<>();

        onResponseModelList.add(new OnResponseModel(R.drawable.kenkon_on));
        onResponseModelList.add(new OnResponseModel(R.drawable.s21_on));
        onResponseModelList.add(new OnResponseModel(R.drawable.true_frog_on));
        onResponseModelList.add(new OnResponseModel(R.drawable.k_on));
        onResponseModelList.add(new OnResponseModel(R.drawable.polo_on));
        onResponseModelList.add(new OnResponseModel(R.drawable.airpods_on));
        onResponseModelList.add(new OnResponseModel(R.drawable.the_moms_on));
        onResponseModelList.add(new OnResponseModel(R.drawable.earpods_on));
        onResponseModelList.add(new OnResponseModel(R.drawable.traq_on));
        onResponseModelList.add(new OnResponseModel(R.drawable.vivo_on));
//        onResponseModelList.add(new OnResponseModel(R.drawable.taneira));
    }

    private void setRecyclerAdapterBrand4uData() {
        GridLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),3,RecyclerView.HORIZONTAL,false);
         brand4UAdapter=new Brand4UAdapter(brand4uModelList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(brand4UAdapter);
    }

    private void buildBrand4uData() {
        brand4uModelList = new ArrayList<>();

        brand4uModelList.add(new Brand4uModel( R.drawable.and_4u));
        brand4uModelList.add(new Brand4uModel( R.drawable.whirlpool_4u));
        brand4uModelList.add(new Brand4uModel( R.drawable.louis_4u));
        brand4uModelList.add(new Brand4uModel( R.drawable.oppo_4u));
        brand4uModelList.add(new Brand4uModel( R.drawable.w_4u));
        brand4uModelList.add(new Brand4uModel( R.drawable.lg_4u));
        brand4uModelList.add(new Brand4uModel( R.drawable.puma_4u));
        brand4uModelList.add(new Brand4uModel( R.drawable.philips_4u));
        brand4uModelList.add(new Brand4uModel( R.drawable.fossil_4u));
    }

    private void setBrandSliderAdapter() {
        brandSlideModelList = new ArrayList<>();
        brandSlideModelList.add(new BrandSlideModel(R.drawable.estside));
        brandSlideModelList.add(new BrandSlideModel(R.drawable.voltas));
        brandSlideModelList.add(new BrandSlideModel(R.drawable.croma));
//        brandSlideModelList.add(new BrandSlideModel(R.drawable.titan));
        brandSlideModelList.add(new BrandSlideModel(R.drawable.beko));
        brandSlideModelList.add(new BrandSlideModel(R.drawable.khai));

    }

    private void setBrandSliderData() {
        mviewPager2.setAdapter(new BrandSlideAdapter(brandSlideModelList, mviewPager2));

        mviewPager2.setClipToPadding(false);
        mviewPager2.setClipChildren(false);
        mviewPager2.setOffscreenPageLimit(3);
        mviewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(15));

        mviewPager2.setPageTransformer(compositePageTransformer);
        mviewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                brandHandler.removeCallbacks(brandSlideRunnable);
                brandHandler.postDelayed(brandSlideRunnable,3000);  //slider duration 3 second
            }
        });
    }
    private Runnable brandSlideRunnable = new Runnable() {
        @Override
        public void run() {
            mviewPager2.setCurrentItem(mviewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        brandHandler.post(brandSlideRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        brandHandler.postDelayed(brandSlideRunnable,3000);
    }
}