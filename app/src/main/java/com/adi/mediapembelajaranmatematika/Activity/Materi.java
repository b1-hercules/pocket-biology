package com.adi.mediapembelajaranmatematika.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.adi.mediapembelajaranmatematika.R;

public class Materi extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        Button btnOpenVideo = findViewById(R.id.btn_open_video);
        ImageView btnKembali = findViewById(R.id.btn_kembali);
        Button btnDashboard = findViewById(R.id.btn_dashboard);
        Button btnMateriGenetik = findViewById(R.id.btn_materi_genetik);
        Button btnKromosom = findViewById(R.id.btn_kromosom);
        Button btndna = findViewById(R.id.btn_dna);
        Button btnrna = findViewById(R.id.btn_rna);
        Button btnGendanAlel = findViewById(R.id.btn_gen_dan_alel);
        Button btnSintesisProtein = findViewById(R.id.btn_sintesis_protein);
        Button btnPewarisanSifat = findViewById(R.id.btn_pewarisan_sifat);
        Button btnPautan = findViewById(R.id.btn_pautan);
        Button btnHereditas = findViewById(R.id.btn_hereditas);
        Button btnMutasi = findViewById(R.id.btn_mutasi);

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

        btnDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/pocketbiology/dashboard"));
                startActivity(intent);
            }
        });

        btnMateriGenetik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/pocketbiology/materi-genetik"));
                startActivity(intent);
            }
        });

        btnKromosom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/pocketbiology/kromosom"));
                startActivity(intent);
            }
        });

        btndna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/pocketbiology/dna"));
                startActivity(intent);
            }
        });

        btnrna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/pocketbiology/rna"));
                startActivity(intent);
            }
        });

        btnGendanAlel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/pocketbiology/gendanalel"));
                startActivity(intent);
            }
        });

        btnSintesisProtein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/pocketbiology/sintesisprotein"));
                startActivity(intent);
            }
        });

        btnPewarisanSifat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/pocketbiology/pewarisansifat"));
                startActivity(intent);
            }
        });

        btnPautan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/pocketbiology/pautan"));
                startActivity(intent);
            }
        });

        btnHereditas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/pocketbiology/hereditas"));
                startActivity(intent);
            }
        });

        btnMutasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/pocketbiology/mutasi"));
                startActivity(intent);
            }
        });
    }
}