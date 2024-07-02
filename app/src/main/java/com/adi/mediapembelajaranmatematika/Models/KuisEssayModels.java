package com.adi.mediapembelajaranmatematika.Models;

public class KuisEssayModels {
    public KuisEssayModels() {

    }

    public String[] pertanyaan = {
            "Apa fungsi RNA polimerase dalam transkripsi?",
            "Jelaskan perbedaan antara genotip dan fenotip.",
            "Bagaimana mutasi dapat mempengaruhi ekspresi gen?",
            "Apa yang dimaksud dengan alel dominan dan alel resesif?",
            "Jelaskan mekanisme pewarisan sifat menurut hukum Mendel."
    };

    public String[] jawabanbenar = {
            "Membantu sintesis RNA dari DNA.",
            "Genotip adalah kode genetik, fenotip adalah ekspresi fisik.",
            "Mutasi mengubah urutan DNA, mempengaruhi fungsi protein.",
            "Alel dominan menutupi efek alel resesif, ditunjukkan pada fenotip.",
            "Sifat diturunkan dari orang tua ke anak melalui unit pewarisan."
    };

    public String[][] kunciJawaban = {
            {"RNA polimerase", "sintesis", "RNA", "DNA"},
            {"genotip", "kode genetik", "fenotip", "ekspresi fisik"},
            {"mutasi", "urutan DNA", "fungsi protein"},
            {"alel dominan", "alel resesif", "fenotip"},
            {"pewarisan", "sifat", "hukum Mendel", "unit"}
    };

    public String getSoal(int x) {
        return pertanyaan[x];
    }

    public String getJawabanbenar(int x) {
        return jawabanbenar[x];
    }

    public String[] getKunciJawaban(int x) {
        return kunciJawaban[x];
    }
}
