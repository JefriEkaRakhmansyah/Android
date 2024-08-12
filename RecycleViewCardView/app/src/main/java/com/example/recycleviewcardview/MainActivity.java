package com.example.recycleviewcardview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SiswaAdapter adapter;
    List<Siswa> siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        load();
        isiData();
    }

    public void load() {
        recyclerView = findViewById(R.id.rcvSiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiData(){
        siswaList = new ArrayList<Siswa>();
        siswaList.add(new Siswa("Budi", "Palembang"));
        siswaList.add(new Siswa("Edi", "Palembang"));
        siswaList.add(new Siswa("Roy", "Palembang"));
        siswaList.add(new Siswa("Ega", "Palembang"));
        siswaList.add(new Siswa("Mamat", "Palembang"));
        siswaList.add(new Siswa("Tejo", "Palembang"));
        siswaList.add(new Siswa("Nurul", "Palembang"));
        siswaList.add(new Siswa("Nunuk", "Palembang"));
        siswaList.add(new Siswa("Hasan", "Palembang"));
        siswaList.add(new Siswa("Evi", "Palembang"));
        siswaList.add(new Siswa("Agus", "Palembang"));
        siswaList.add(new Siswa("Cino", "Palembang"));
        siswaList.add(new Siswa("Toni", "Palembang"));

        adapter = new SiswaAdapter(this,siswaList);
        recyclerView.setAdapter(adapter);
    }

}