package com.merahputihku.exploreindonesia.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.merahputihku.exploreindonesia.Models.Provinsi;
import com.merahputihku.exploreindonesia.R;

import java.util.List;

/**
 * Created by doy on 2/11/17.
 */

public class ProvinsiRecyclerAdapter extends RecyclerView.Adapter<ProvinsiRecyclerAdapter.ViewHolderKu> {

    private Context mContext;
    private List<Provinsi> mProvinsiList;

    public ProvinsiRecyclerAdapter(Context context, List<Provinsi> provinsiList){
        this.mContext = context;
        this.mProvinsiList = provinsiList;
    }
    @Override
    public ViewHolderKu onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.privinsi_row_layout, parent, false);

        return new ViewHolderKu(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolderKu holder, int position) {
        Provinsi mProvinsi = mProvinsiList.get(position);
        holder.namaProvinsi.setText(mProvinsi.getNama());
        holder.totalWisata.setText(String.valueOf(mProvinsi.getTotal()));
        holder.imgProvinsi.setImageResource(mProvinsi.getImage());
    }

    @Override
    public int getItemCount() {
        return mProvinsiList.size();
    }

    public class ViewHolderKu extends RecyclerView.ViewHolder {
        public TextView namaProvinsi, totalWisata;
        public ImageView imgProvinsi;

        public ViewHolderKu(View itemView) {
            super(itemView);
            namaProvinsi = (TextView)itemView.findViewById(R.id.nama_provinsi);
            totalWisata = (TextView)itemView.findViewById(R.id.total_wisata_provinsi);
            imgProvinsi = (ImageView)itemView.findViewById(R.id.provinsi_img);
        }
    }
}
