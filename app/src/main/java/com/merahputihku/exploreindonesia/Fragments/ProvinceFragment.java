package com.merahputihku.exploreindonesia.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.merahputihku.exploreindonesia.Adapter.ProvinsiRecyclerAdapter;
import com.merahputihku.exploreindonesia.KotaActivity;
import com.merahputihku.exploreindonesia.Listener.ProvinsiRecyclerItemListener;
import com.merahputihku.exploreindonesia.Models.Provinsi;
import com.merahputihku.exploreindonesia.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProvinceFragment extends Fragment {

    private List<Provinsi> mProvinsiList;
    private ProvinsiRecyclerAdapter mProvinsiRecyclerAdapter;

    public ProvinceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_province, container, false);
        mProvinsiList = new ArrayList<>();
        mProvinsiRecyclerAdapter = new ProvinsiRecyclerAdapter(getContext(), mProvinsiList);
        final RecyclerView mRecyclerView = (RecyclerView)rootView.findViewById(R.id.provinsi_recycler_view);
        RecyclerView.LayoutManager mRecyclerLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(mRecyclerLayoutManager);
        mRecyclerView.setAdapter(mProvinsiRecyclerAdapter);

        mRecyclerView.addOnItemTouchListener(
                new ProvinsiRecyclerItemListener(getContext(), new ProvinsiRecyclerItemListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
//                        Toast.makeText(getContext(), "Yolooo Pos = " + position, Toast.LENGTH_SHORT).show();
                        TextView namaProvinsi = (TextView)view.findViewById(R.id.nama_provinsi);
//                        Toast.makeText(getContext(), namaProvinsi.getText().toString(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(), KotaActivity.class);
                        intent.putExtra("PROVINSI", namaProvinsi.getText().toString());
                        startActivity(intent);
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
                "Sumatra Selatan", "Sumatra Barat",
                "Jawa Timur", "Jawa Tengah",
                "Jawa Barat", "DIY Yogyakarta",
                "DKI Jakarta", "Sulawesi Selatan",
                "Provinsi Anyar", "Provinsi Lawas"
        };
        for(int i = 0; i < mNamaProvinsi.length; i ++) {
            provinsi = new Provinsi(mNamaProvinsi[i], acak.nextInt((500 - 1) + 1) + 1, imgProvinsi[i]);
            mProvinsiList.add(provinsi);
        }
    }

}
