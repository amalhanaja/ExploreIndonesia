package com.merahputihku.exploreindonesia;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.merahputihku.exploreindonesia.Adapter.ProvinsiRecyclerAdapter;
import com.merahputihku.exploreindonesia.Adapter.TabLayoutViewPagerAdapter;
import com.merahputihku.exploreindonesia.Dekorasi.GridSpacingItemDecoration;
import com.merahputihku.exploreindonesia.Fragments.MostPopularFragment;
import com.merahputihku.exploreindonesia.Fragments.ProvinceFragment;
import com.merahputihku.exploreindonesia.Listener.ProvinsiRecyclerItemListener;
import com.merahputihku.exploreindonesia.Models.Provinsi;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MaterialSearchView mMaterialSearchView;
    private MaterialSearchView.OnQueryTextListener mOnQueryTextListener = new MaterialSearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            mMaterialSearchView.setSuggestions(getResources().getStringArray(R.array.lokasi));
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mMaterialSearchView = (MaterialSearchView)findViewById(R.id.search_view);
        mMaterialSearchView.setOnQueryTextListener(mOnQueryTextListener);
        getSupportActionBar().setTitle(R.string.app_name);
        mViewPager = (ViewPager)findViewById(R.id.explore_view_pager);
        setupViewPager(mViewPager);
        mTabLayout = (TabLayout)findViewById(R.id.tab_explore);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager mViewPager) {
        TabLayoutViewPagerAdapter adapter = new TabLayoutViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProvinceFragment(), "Province");
        adapter.addFragment(new MostPopularFragment(), "Popular");
        mViewPager.setAdapter(adapter);
    }
//    private int dpToPx(int dp){
//        Resources mResources = getResources();
//        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, mResources.getDisplayMetrics()));
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem mSearchViewMenuItem = menu.findItem(R.id.action_search);
        mMaterialSearchView.setMenuItem(mSearchViewMenuItem);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (mMaterialSearchView.isSearchOpen()){
            mMaterialSearchView.closeSearch();
        }else {
            super.onBackPressed();
        }
    }
}
