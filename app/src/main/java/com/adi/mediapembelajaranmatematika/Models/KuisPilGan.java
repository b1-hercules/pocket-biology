package com.adi.mediapembelajaranmatematika.Models;

import android.widget.ImageView;

public class KuisPilGan {

    public KuisPilGan() {
    }

    public String[] pertanyaan = {
            "1. Apa fungsi utama DNA dalam sel?",
            "2. Alel yang dominan akan menunjukkan efeknya ketika hadir dalam jumlah...",
            "3. Hukum segregasi Mendel menjelaskan bahwa...",
            "4. Dalam persilangan dihibrid, rasio fenotipik yang diharapkan menurut hukum Mendel adalah...",
            "5. Mutasi yang terjadi pada satu basa nitrogen dalam DNA disebut...",
            "6. Proses memindahkan gen dari satu organisme ke organisme lain disebut...",
            "7. Organisme yang mengandung DNA dari spesies lain disebut...",
            "8. Apa tujuan utama dari terapi gen?",
            "9. Salah satu dampak etis dari bioteknologi genetika adalah...",
            "10. Prinsip dasar rekayasa genetik melibatkan..."
    };

    public String pilihanjawaban[][] = {
            {"A. Membantu dalam proses pencernaan", "B. Menghasilkan energi untuk sel", "C. Menyimpan informasi genetik", "D. Melindungi sel dari kerusakan fisik"},
            {"A. Satu saja", "B. Dua atau lebih", "C. Tiga atau lebih", "D. Empat atau lebih"},
            {"A. Pasangan alel dipisahkan selama pembentukan gamet", "B. Keturunan mendapat satu faktor dari setiap orang tua", "C. Sifat-sifat dapat diwariskan secara independen", "D. Mutasi dapat mempengaruhi pewarisan sifat"},
            {"A. 3:1", "B. 9:3:3:1", "C. 1:2:1", "D. 1:1"},
            {"A. Inversi", "B. Duplikasi", "C. Translokasi", "D. Mutasi titik"},
            {"A. Kloning", "B. Rekombinasi DNA", "C. Transkripsi", "D. Translasi"},
            {"A. Mutan", "B. Heterozigot", "C. Transgenik", "D. Homozigot"},
            {"A. Mengubah sifat fisik organisme", "B. Mengobati penyakit genetik", "C. Meningkatkan produksi pertanian", "D. Membuat organisme lebih tahan terhadap penyakit"},
            {"A. Meningkatkan efisiensi energi", "B. Mempertanyakan hak paten atas material genetik", "C. Mempercepat proses evolusi", "D. Mengurangi diversitas genetik"},
            {"A. Penyilangan antar spesies yang berbeda secara alami", "B. Penggunaan antibiotik dalam pangan", "C. Memotong dan menyambung DNA untuk menciptakan DNA rekombinan", "D. Mengubah urutan basa nitrogen tanpa mempengaruhi gen"}
    };

    public String[] jawabanbenar = {
            "C. Menyimpan informasi genetik",
            "A. Satu saja",
            "A. Pasangan alel dipisahkan selama pembentukan gamet",
            "B. 9:3:3:1",
            "D. Mutasi titik",
            "B. Rekombinasi DNA",
            "C. Transgenik",
            "B. Mengobati penyakit genetik",
            "B. Mempertanyakan hak paten atas material genetik",
            "C. Memotong dan menyambung DNA untuk menciptakan DNA rekombinan"
    };

    public String getSoal(int x) {
        return pertanyaan[x];
    }

    public String getPilihanJawaban1(int x) {
        return pilihanjawaban[x][0];
    }

    public String getPilihanJawaban2(int x) {
        return pilihanjawaban[x][1];
    }

    public String getPilihanJawaban3(int x) {
        return pilihanjawaban[x][2];
    }

    public String getPilihanJawaban4(int x) {
        return pilihanjawaban[x][3];
    }

    public String getJawabanbenar(int x) {
        return jawabanbenar[x];
    }
}
