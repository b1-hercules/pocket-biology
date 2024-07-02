package com.adi.mediapembelajaranmatematika.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adi.mediapembelajaranmatematika.Models.DaftarNilaiModels;
import com.adi.mediapembelajaranmatematika.Models.KuisEssayModels;
import com.adi.mediapembelajaranmatematika.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import io.github.kexanie.library.MathView;
//import com.github.jianzhongli.MathView;
import com.jstarczewski.pc.mathview.src.MathView;

public class KuisEssay extends AppCompatActivity {

    private TextView tv_skorEssay, tv_nama, tv_jenis_kelamin, tv_nilai, tv_jenis_kuis;
    private MathView tv_soalesay;
    private ImageView btn_kembali;
    private EditText edt_jawaban;
    private Button btn_kirimjawban;
    private TextView tv_jawabanBenar;
    private Button btn_next_soal;
    private FirebaseAuth auth;
    private DatabaseReference reference;
    int x = 0;
    int arr;
    int skor;
    String jawaban;
    private KuisEssayModels kuisEssayModels = new KuisEssayModels();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_essay);
        init();

        // Inisialisasi TextView Jawaban Benar
        tv_jawabanBenar = findViewById(R.id.tv_jawabanBenar);

        // Inisialisasi Button Next Soal
        btn_next_soal = findViewById(R.id.btn_next_soal);
        btn_next_soal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setKontent(); // Menyiapkan soal selanjutnya
                btn_next_soal.setVisibility(View.GONE); // Sembunyikan tombol next setelah diklik
                btn_kirimjawban.setVisibility(View.VISIBLE); // Tampilkan kembali tombol kirim jawaban
            }
        });
    }

    private void init() {

        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();

        btn_kembali = findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KuisEssay.super.onBackPressed();
            }
        });

        tv_nama = findViewById(R.id.tv_nama);
        tv_nama.setText("" + getIntent().getStringExtra("nama"));
        tv_jenis_kelamin = findViewById(R.id.tv_jenis_kelamin);
        tv_jenis_kelamin.setText("" + getIntent().getStringExtra("jenis_kelamin"));
        tv_jenis_kuis = findViewById(R.id.tv_nama_tugas);
        tv_jenis_kuis.setText("" + getIntent().getStringExtra("jenis_kuis"));
        tv_nilai = findViewById(R.id.tv_nilai);
        tv_nilai.setText("" + getIntent().getStringExtra("nilai"));

        tv_skorEssay = findViewById(R.id.tv_skor);
        edt_jawaban = findViewById(R.id.edt_jawaban);
        btn_kirimjawban = findViewById(R.id.btn_next);
        btn_kirimjawban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chekJawaban();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_soalesay = findViewById(R.id.tv_soal);
        setKontent();
    }

    private void chekJawaban() {
        String jawabanUser = edt_jawaban.getText().toString().toLowerCase(); // Mengambil dan memproses jawaban pengguna
        boolean jawabanBenar = false;

        // Periksa setiap kata kunci dalam array kunci jawaban untuk pertanyaan saat ini
        for (String kataKunci : kuisEssayModels.getKunciJawaban(x-1)) { // x-1 karena x sudah diincrement di setKontent()
            if (jawabanUser.contains(kataKunci.toLowerCase())) {
                jawabanBenar = true;
                break; // Keluar dari loop jika sudah menemukan satu kata kunci
            }
        }

        if (jawabanBenar) {
            skor += 20; // Atau sistem penilaian lain sesuai kebutuhan
            Toast.makeText(this, "Jawaban yang benar adalah: " + jawaban, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Jawaban yang benar adalah: " + jawaban, Toast.LENGTH_SHORT).show();
        }
        tv_skorEssay.setText("" + skor);
        //setKontent(); // Menyiapkan konten soal berikutnya atau menyelesaikan kuis

        // Setelah mengecek jawaban, tampilkan jawaban yang benar
        tv_jawabanBenar.setText("Jawaban yang benar: " + jawaban);
        tv_jawabanBenar.setVisibility(View.VISIBLE); // Pastikan TextView terlihat

        // Sembunyikan tombol kirim jawaban dan tampilkan tombol next
        btn_kirimjawban.setVisibility(View.GONE);
        if (x <= arr) {
            btn_next_soal.setVisibility(View.VISIBLE);
        }
    }


    private void setKontent() {
        edt_jawaban.setText(null);
        tv_jawabanBenar.setVisibility(View.GONE);
        arr = kuisEssayModels.pertanyaan.length;
        if (x >= arr) {
            String jumlahSkor = String.valueOf(skor);
            Intent i = new Intent(KuisEssay.this, Hasil.class);
            i.putExtra("skorAkhir", jumlahSkor);
            i.putExtra("activity", "Essay");
            i.putExtra("nama", tv_nama.getText().toString());
            i.putExtra("jenis_kelamin", tv_jenis_kelamin.getText().toString());
            i.putExtra("nama_tugas", tv_jenis_kuis.getText().toString());
            i.putExtra("nilai", tv_skorEssay.getText().toString());
            startActivity(i);
            updateHasil();
            finish();
        } else {
            tv_soalesay.setText(kuisEssayModels.getSoal(x));
            jawaban = kuisEssayModels.getJawabanbenar(x);
        }
        x++;
    }

    private void updateHasil() {
        String nama_pengguna = tv_nama.getText().toString();
        String jenis_kelamin = tv_jenis_kelamin.getText().toString();
        String nilai_hasil = tv_skorEssay.getText().toString();
        String tugas = tv_jenis_kuis.getText().toString();

        if (isEmpty(nama_pengguna) || isEmpty(jenis_kelamin) || isEmpty(nilai_hasil) || isEmpty(tugas)) {
            Toast.makeText(this, "Data tidak boleh kosong!", Toast.LENGTH_SHORT).show();
        } else {
            DaftarNilaiModels kuisEssay = new DaftarNilaiModels();
            kuisEssay.setNama(tv_nama.getText().toString());
            kuisEssay.setJenis_kelamin(tv_jenis_kelamin.getText().toString());
            kuisEssay.setNilai(tv_skorEssay.getText().toString());
            kuisEssay.setJenis_kuis(tv_jenis_kuis.getText().toString());
            updateData(kuisEssay);
        }
    }

    private void updateData(DaftarNilaiModels kuisEssay) {
        String userID = auth.getUid();
        String getKey = getIntent().getStringExtra("key");

        reference.child("kuis_essay")
                .child("daftar_nilai")
                .child(getKey)
                .setValue(kuisEssay)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        tv_nama.setText("");
                        tv_jenis_kelamin.setText("");
                        tv_skorEssay.setText("");
                        tv_jenis_kuis.setText("");
                        Toast.makeText(KuisEssay.this, "Data berhasil", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private boolean isEmpty(String s) {
        return TextUtils.isEmpty(s);
    }
}