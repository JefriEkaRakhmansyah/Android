package com.example.recycleviewcardview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {

    private final Context context;
    private final List<Siswa> siswalist;

    public SiswaAdapter(Context context, List<Siswa> siswalist) {
        this.context = context;
        this.siswalist = siswalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int viewType) {
        android.view.ViewGroup viewGroup = null;
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_siswa,viewGroup, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int p) {
        Siswa siswa = siswalist.get(p);
        ViewHolder.tvNama.setText(siswa.getNama());
        ViewHolder.tvAlamat.setText(siswa.getAlamat());
    /*
        ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Nama :"+siswa.getNama()+" Alamat : "+siswa.getAlamat(), Toast.LENGTH_SHORT).show();
            }
        });
        */

        ViewHolder.tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context,ViewHolder.tvMenu);
                popupMenu.inflate(R.menu.menu_option);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        MenuItem item = null;
                        switch (item.getItemId()){
                            case R.id.menu_simpan:
                                Toast.makeText(context, "Simpan Data"+siswa.getNama(), Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.menu_hapus:
                                    siswalist.remove(p);
                                    notifyDataSetChanged();
                                    Toast.makeText(context, siswa.getNama()+"Sudah di Hapus", Toast.LENGTH_SHORT).show();
                                break;

                        }


                        return false;
                    }
                });

                ();
            }
        });


    }

    @Override
    public int getItemCount() {
        return siswalist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        static TextView tvNama;
        static TextView tvAlamat;
        static TextView tvMenu;
        public static View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvMenu = itemView.findViewById(R.id.tvMenu);
        }
    }

}
