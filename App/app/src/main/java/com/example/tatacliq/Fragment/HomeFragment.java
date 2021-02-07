package com.example.tatacliq.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tatacliq.BrandNewOnCliq.OnAdapter;
import com.example.tatacliq.BrandNewOnCliq.OnResponseModel;
import com.example.tatacliq.HomeClickLister;
import com.example.tatacliq.PersonalBasicsStuffs.PersonalBasicAdapter;
import com.example.tatacliq.PersonalBasicsStuffs.PersonalBasicStuffs;
import com.example.tatacliq.R;
import com.example.tatacliq.SlideItem.SliderAdapter;
import com.example.tatacliq.SlideItem.SliderItem;
import com.example.tatacliq.WestSideRecyclerView.WestSideAdapter;
import com.example.tatacliq.WestSideRecyclerView.WestsideItemClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class HomeFragment extends Fragment implements HomeClickLister {

    private RecyclerView mRecyclerWestSide;
    private ArrayList<WestsideItemClass> westsideItemClassList;
    private List<SliderItem> sliderItemList;
    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    private List<OnResponseModel>onResponseModelList;
    private OnAdapter onAdapter;
    private RecyclerView mRecyclerViewOn;
    private RecyclerView mRecyclerBasicStuffs;
    private List<PersonalBasicStuffs> personalBasicStuffsList;
    private RelativeLayout mrelativeLayout;
    private HomeClickLister homeClickLister;
    private FrameLayout sFrameLayout;

private FragmentManager fragmentManager;



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
        mRecyclerViewOn=view.findViewById(R.id.recyclerBrandNewOnCliq);
        mRecyclerBasicStuffs=view.findViewById(R.id.recyclerBasicStuffs);
        mrelativeLayout=view.findViewById(R.id.relativeSBI);
        sFrameLayout=view.findViewById(R.id.frameContainer);
        setWestSideRecyclerAdapter();
        setWestSideRecyclerData();
        setSliderAdapter();
        setSliderData();
        buildBrandOnNewCliqData();
        setRecyclerAdapterBrandOnNewCliqData();
        buildBasicStuffs();
        setRecyclerAdapterBasicStuffs();
//       setFragment(new HomeFragmentInsideWebView());
    }

//    private void setFragment(Fragment fragment) {
//        FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
//        fragmentTransaction.replace()
//    }


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
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 1,
                RecyclerView.HORIZONTAL, false);
        WestSideAdapter westSideAdapter = new WestSideAdapter(westsideItemClassList,this);
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
        onResponseModelList.add(new OnResponseModel(R.drawable.taneira_on));
    }

    private void setRecyclerAdapterBrandOnNewCliqData() {
        GridLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),1,RecyclerView.HORIZONTAL,false);
        onAdapter=new OnAdapter(onResponseModelList);
        mRecyclerViewOn.setLayoutManager(linearLayoutManager);
        mRecyclerViewOn.setAdapter(onAdapter);
    }

    private void buildBasicStuffs() {
        personalBasicStuffsList=new ArrayList<>();

        personalBasicStuffsList.add(new PersonalBasicStuffs(R.drawable.basicskin,"COMFORTABLE LINGERIE","A selection of lingerie that fits like","no other.","Explore"));
        personalBasicStuffsList.add(new PersonalBasicStuffs(R.drawable.basicdryer,"PERSONAL BASICS","Personal care basics for you to","look your best.","Explore"));
        personalBasicStuffsList.add(new PersonalBasicStuffs(R.drawable.basicwatch,"STYLISH WATCHES","Stunning timepieces that are sure","to make a mark.","Explore"));
        personalBasicStuffsList.add(new PersonalBasicStuffs(R.drawable.jewellery,"JEWELLERY SELECTION","Precious piece that bring together","tradition and trend","Explore"));
        personalBasicStuffsList.add(new PersonalBasicStuffs(R.drawable.basicheadphones,"AUDIO ESSENTIAL","CliQ to get access to the best in","the world","Explore"));
        personalBasicStuffsList.add(new PersonalBasicStuffs(R.drawable.basicfragrance,"BEST OF FRAGRANCES","Fragrance guaranteed to put the","spring in your step","Explore"));
    }

        private void setRecyclerAdapterBasicStuffs() {

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),1,RecyclerView.HORIZONTAL,false);
            PersonalBasicAdapter adapter=new PersonalBasicAdapter(personalBasicStuffsList);
            mRecyclerBasicStuffs.setLayoutManager(gridLayoutManager);
            mRecyclerBasicStuffs.setAdapter(adapter);
        }

    @Override
    public void onClickedWishListed(WestsideItemClass westsideItemClass) {
        Toast.makeText(getContext(),"Name "+westsideItemClass.getCategoryText(),Toast.LENGTH_SHORT).show();
//        sk=westsideItemClass.getCategoryText();
    }
}
