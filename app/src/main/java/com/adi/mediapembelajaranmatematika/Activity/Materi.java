package com.adi.mediapembelajaranmatematika.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.adi.mediapembelajaranmatematika.Adapter.CustomAdapter;
import com.adi.mediapembelajaranmatematika.Models.MateriModels;
import com.adi.mediapembelajaranmatematika.R;

import java.util.ArrayList;

public class Materi extends AppCompatActivity {

    private ArrayList<MateriModels> materiModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        initModelList();
        Button btnOpenVideo = findViewById(R.id.btn_open_video);
        ImageView btnKembali = findViewById(R.id.btn_kembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnOpenVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=pRLzqHAWTcs&ab_channel=GIAAcademy"));
                startActivity(intent);
            }
        });

        RecyclerView rv = findViewById(R.id.rv);
        rv.setAdapter(new CustomAdapter(materiModels));

    }

    private void initModelList() {
        materiModels.add(new MateriModels("Dashboard", R.drawable.ic_materi_dashboard,"https://sites.google.com/view/pocketbiology/dashboard"));
        materiModels.add(new MateriModels("Materi Genetik",  R.drawable.ic_materi_genetic,"https://sites.google.com/view/pocketbiology/materi-genetik"));
        materiModels.add(new MateriModels("Kromosom",  R.drawable.ic_materi_kromosom,"https://sites.google.com/view/pocketbiology/kromosom"));
        materiModels.add(new MateriModels("DNA",  R.drawable.ic_materi_dna,"https://sites.google.com/view/pocketbiology/dna"));
        materiModels.add(new MateriModels("RNA",  R.drawable.ic_materi_rna,"https://sites.google.com/view/pocketbiology/rna"));
        materiModels.add(new MateriModels("Gen dan Alel",  R.drawable.ic_materi_dan_alel ,"https://sites.google.com/view/pocketbiology/gendanalel"));
        materiModels.add(new MateriModels("Sintesis Protein",   R.drawable.ic_materi_protein,"https://sites.google.com/view/pocketbiology/sintesisprotein"));
        materiModels.add(new MateriModels("Pewarisan Sifat",  R.drawable.ic_materi_pewarisan_sifat,"https://sites.google.com/view/pocketbiology/pewarisansifat"));
        materiModels.add(new MateriModels("Pautan",  R.drawable.ic_materi_pautan,"https://sites.google.com/view/pocketbiology/pautan"));
        materiModels.add(new MateriModels("Hereditas",  R.drawable.ic_materi_hereditas,"https://sites.google.com/view/pocketbiology/hereditas"));
        materiModels.add(new MateriModels("Mutasi",  R.drawable.ic_materi_mutasi,"https://sites.google.com/view/pocketbiology/mutasi"));
    }
}

