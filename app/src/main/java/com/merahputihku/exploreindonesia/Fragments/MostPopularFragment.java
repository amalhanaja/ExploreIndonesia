package com.merahputihku.exploreindonesia.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.merahputihku.exploreindonesia.Adapter.ProvinsiRecyclerAdapter;
import com.merahputihku.exploreindonesia.Listener.ProvinsiRecyclerItemListener;
import com.merahputihku.exploreindonesia.Models.Provinsi;
import com.merahputihku.exploreindonesia.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class MostPopularFragment extends Fragment {

    private List<Provinsi> mProvinsiList;
    private ProvinsiRecyclerAdapter mProvinsiRecyclerAdapter;

    public MostPopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_province, container, false);
        mProvinsiList = new ArrayList<>();
        mProvinsiRecyclerAdapter = new ProvinsiRecyclerAdapter(getContext(), mProvinsiList);
        RecyclerView mRecyclerView = (RecyclerView)rootView.findViewById(R.id.provinsi_recycler_view);
        RecyclerView.LayoutManager mRecyclerLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(mRecyclerLayoutManager);
        mRecyclerView.setAdapter(mProvinsiRecyclerAdapter);

        mRecyclerView.addOnItemTouchListener(
                new ProvinsiRecyclerItemListener(getContext(), new ProvinsiRecyclerItemListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(getContext(), "Yolooo Pos = " + position, Toast.LENGTH_SHORT).show();
                    }
                }));
        prepareProvinsi();
        return rootView;
    }

    private void prepareProvinsi() {
        Provinsi provinsi;
        Random acak = new Random(); //For Testing Sum of Destination
        int[] imgProvinsi = {
                R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher,
        };
        String[] mNamaProvinsi = {
                "Raja Sata", "Raja Daa",
                "Raja Taga", "Raja Ampat",
                "Raja Lama", "Raja Anam",
                "Raja Tajah", "Raja Dalapan",
                "Raja Sambalan", "Raja Sapalah"
        };
        for(int i = 0; i < mNamaProvinsi.length; i ++) {
            provinsi = new Provinsi(mNamaProvinsi[i], acak.nextInt((500 - 1) + 1) + 1, imgProvinsi[i]);
            mProvinsiList.add(provinsi);
        }
    }
}
